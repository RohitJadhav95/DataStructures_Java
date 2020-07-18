package com.techsolutions;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListQueue {

    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
          this.value = value;
        };
    }

    private Node first;
    private Node last;
    private int count;

    public void enqueue(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        count++;
    };

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        int value;
        if (first == last) {
            value = first.value;
            first = last = null;
        }

        var node = first.next;
        value = first.value;
        first.next = null;
        first = node;

        count--;

        return value;
    };

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        return first.value;
    };

    public int size() {
      return count;
    };

    public boolean isEmpty() {
        return first == null;
    };

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();

        var node = first;
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }

        return list.toString();
    }
}
