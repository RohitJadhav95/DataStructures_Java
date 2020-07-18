package com.techsolutions;

import com.sun.source.tree.Tree;
import jdk.dynalink.NamedOperation;

import java.util.ArrayList;

public class BinaryTree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null){
            root = new Node(value);
            return;
        }

        Node node = root;
        Node parent = node;

        while (node != null) {
            parent = node;
            if (node.value < value) {
                node = node.rightChild;
            } else node = node.leftChild;
        }

        if (parent.value < value){
            parent.rightChild = new Node(value);
        } else if (parent.value > value)
            parent.leftChild = new Node(value);
    }

    public boolean find(int value) {
        Node node = root;

        while (node != null) {
            if (node.value == value)
                return true;
            else if (node.value < value)
                node = node.rightChild;
             else
                 node = node.leftChild;
        }

        return false;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    };

    public void inOrderTraverse() {
        inOrderTraverse(root);
    };

    public void postOrderTraverse() {
        postOrderTraverse(root);
    };

    public int treeHeight() {
        return treeHeight(root);
    }

    public int minValue() {
        return minValue(root);
    }

    public int maxValue() {
        return maxValue(root);
    }

    public boolean equals(BinaryTree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    public void swapRoot() {
        Node node = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = node;
    };

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    };

    public ArrayList<Integer> kDistance(int distance){
        if (distance < 0)
            throw new IllegalArgumentException();
        var list = new ArrayList<Integer>();
        kDistance(root, distance, list);
        return list;

    };

    public void levelOrderTraverse() {
        var list = new ArrayList<Integer>();

        for (int i = 0; i <= treeHeight(); i++) {
            for (var item : kDistance(i))
                System.out.println(item);
        }

        for (var item : list)
            System.out.println(item);
    };

    public int size() {
        return size(root, 0);
    };

    public int countLeaves() {
      return countLeaves(root, 0);
    };

    public boolean contains(int value) {
        return contains(root, value);
    };

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(root, value1, value2);
    };

    public ArrayList<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    };

    private void getAncestors(Node root, int value, ArrayList<Integer> list) {
        if (root == null || isLeaf(root))
            return;

        if (root.value < value){
            list.add(root.value);
            if (root.rightChild.value == value)
                return;
            else getAncestors(root.rightChild, value, list);
        } else if (root.value > value){
            list.add(root.value);
            if (root.leftChild.value == value)
                return;
            else getAncestors(root.leftChild, value, list);
        } else {
            list.clear();
            return;
        }

    };

    private boolean areSiblings(Node root, int value1, int value2) {
        if (root == null || isLeaf(root))
            return false;

        if ((root.rightChild.value == value1 || root.rightChild.value == value2)
            && (root.leftChild.value == value1 || root.leftChild.value == value2))
            return true;

        return areSiblings(root.leftChild, value1, value2) || areSiblings(root.rightChild, value1, value2);
    };

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        return (root.value == value)
                || contains(root.leftChild, value)
                || contains(root.rightChild, value);
    };

    private int countLeaves(Node root, int count) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            count++;

        return count + countLeaves(root.leftChild,count) + countLeaves(root.rightChild,count);
    };

    private int size(Node root, int size) {
        Node node = root;
        if (node == null)
            return size;

        size++;
        size = size(node.leftChild, size);
        size = size(node.rightChild, size);
        return size;
    };

    private void kDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        kDistance(root.leftChild, distance - 1, list);
        kDistance(root.rightChild, distance - 1, list);
    };

    private boolean isBinarySearchTree(Node root, int lowLimit, int upLimit ) {
        Node node = root;

        if (node == null)
            return true;

        return  (lowLimit < node.value && node.value < upLimit)
                && isBinarySearchTree(root.leftChild, lowLimit , root.value )
                && isBinarySearchTree(root.rightChild, root.value , upLimit);
    }

    private boolean equals(Node root1, Node root2){
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null)
            return root1.value == root2.value
                    && equals(root1.leftChild, root2.leftChild)
                    && equals(root1.rightChild, root2.rightChild);

        return false;
    }

    private int minValue(Node root) {
        if (root == null)
            throw new IllegalStateException();

        if (root.leftChild == null)
            return root.value;

        return minValue(root.leftChild);
    };

    private int maxValue(Node root) {
        if (root == null)
            throw new IllegalStateException();

        if (root.rightChild == null)
            return root.value;

        return maxValue(root.rightChild);
    };

//  Need to check again
//    private int minValueBinaryTree(Node root){

//        Node node = root;
//        int min;
//
//        if (node.leftChild == null && node.rightChild == null)
//            return node.value;
//
//        var left = minValueBinaryTree(node.leftChild);
//        var right = minValueBinaryTree(node.rightChild);
//
//
//        return Math.min(Math.min(left,right), node.value);
//    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    };

    private int treeHeight(Node root) {
        Node node = root;

        if (node == null)
            return -1;

        return 1 + max(treeHeight(node.leftChild), treeHeight(node.rightChild));
    };

    private int max(int first, int second) {
        return first > second ? first : second;
    }

    private void preOrderTraverse(Node root) {
        Node node = root;

        if (node == null)
            return;

        System.out.println(node.value);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    };

    private void inOrderTraverse(Node root) {
        Node node = root;

        if (node == null)
            return;

        inOrderTraverse(node.leftChild);
        System.out.println(node.value);
        inOrderTraverse(node.rightChild);
    };

    private void postOrderTraverse(Node root) {
        Node node = root;

        if (node == null)
            return;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.value);
    };
}
