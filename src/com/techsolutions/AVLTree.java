package com.techsolutions;

import jdk.dynalink.NamedOperation;

public class AVLTree {

    private class Node {
        private int value;
        private int height;
        private Node rightChild;
        private Node leftChild;

        public Node(int value) {
            this.value = value;
        };

        @Override
        public String toString() {
            return "Value:" + this.value + " and " + "Height:" + this.height;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    };

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        root = balance(root);

        return root;
    };

    private Node balance(Node node) {

        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) > 0)
                node = leftRotate(node.leftChild);
            node = rightRotate(node);
        }

        if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) < 0)
                node = rightRotate(node.rightChild);
            node = leftRotate(node);
        }

        return node;
    };

    private Node rightRotate(Node node) {
        Node temp = null;
        if (node.leftChild.rightChild != null)
            temp = node.leftChild.rightChild;
        node.leftChild.rightChild = node;
        node = node.leftChild;
        node.rightChild.leftChild = temp;
        node.rightChild.height -= 2;
        return node;
    };

    private Node leftRotate(Node node) {
        Node temp = null;
        if (node.rightChild.leftChild != null)
            temp = node.rightChild.leftChild;
        node.rightChild.leftChild = node;
        node = node.rightChild;
        node.leftChild.rightChild = temp;
        node.leftChild.height -= 2;
        return node;
    };

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) < -1;
    };

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) > 1;
    };

    private int balanceFactor(Node node) {
        return height(node.rightChild) - height(node.leftChild);
    };

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }
}
