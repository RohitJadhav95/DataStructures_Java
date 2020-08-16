package com.techsolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.*;

public class Trie {
    private class Node {
        private char value;
        private Map<Character, Node> children = new HashMap<>();
        Boolean isEndOfWord = false;

        private Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null || word == null)
            return false;

        Node current =  root;

        for (char ch :  word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void remove(String word) {
        if (!contains(word)) return;
        remove(word, root, 0);
    }

    public List<String> autoComplete(String prefix) {
        List<String> list = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix.toLowerCase());
        autoComplete(prefix.toLowerCase(), lastNode, list);
        return list;
    }

    private void autoComplete(String word, Node node, List<String> words) {
        if (node == null)
            return;

        if (node.isEndOfWord)
            words.add(word);

        for (var child : node.getChildren()) {
            autoComplete(word + child.value, child, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.hasChild(ch))
                return null;
            current = current.getChild(ch);
        }

        return current;
    }

    private void remove(String word, Node node, int index) {
        if (index == word.length()) {
            node.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = node.getChild(ch);

        remove(word, child,index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            node.removeChild(ch);
    }

}

