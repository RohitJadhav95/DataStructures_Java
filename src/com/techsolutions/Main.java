package com.techsolutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();


        trie.insert("Car");
        trie.insert("card");
        trie.insert("careful");
        trie.insert("care");
        trie.insert("egg");
        var result = trie.autoComplete("C");
        System.out.println(result);

    };






//    public static void reverse(Queue<Integer> queue) {
//        if (queue.isEmpty()) throw new IllegalStateException();
//
//        Stack<Integer> stack = new Stack<>();
//        while (!queue.isEmpty()) {
//            var front = queue.remove();
//            stack.push(front);
//        }
//
//        while (!stack.isEmpty()) {
//            var top = stack.pop();
//            queue.add(top);
//        }
//    };
}

