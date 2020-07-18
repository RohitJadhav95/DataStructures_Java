package com.techsolutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        tree.insert(12);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);

        System.out.println("Hi");
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

