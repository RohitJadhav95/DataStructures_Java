package com.techsolutions;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        };
    }

    private Node first;
    private Node last;
    private int size = 0;

//    public LinkedList() {
//        this.first = new Node();
//        this.last = new  Node();
//    };

    public void addFirst(int item) {
        var node = new Node(item);
        if(isEmpty()){
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    };

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()){
            first = last = node;
        } else {
            last.next = node;
            last = node;
        };
        size++;
    };

    public int indexOf(int item){
        var node = first;
        int index = 0;
        int flag = 1;
        while (node != null) {
            if (node.value == item)
                return index;
            index++;
            node = node.next;
        };
        return -1;
    };

    public boolean contains(int item) {
        return indexOf(item) != -1;
    };

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var node = first.next;
            first.next = null;
            first = node;
        }
        size--;
    };

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last){
            first = last = null;
            return;
        } else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    };

    public int size() {
        return size;
    };

    public int[] toArray() {
        int [] array = new int[size];
        var node = first;
        int count = 0;
        while (node != null) {
            array[count++] = node.value;
            node = node.next;
        }
        return array;
    };

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = previous.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first.next = null;
        first = previous;


//  My Implementation (Bad!!!!) O(n^2)
//        if (first != last) {
//            var node = last;
//            Node previous;
//            while (node != null) {
//                if (node != first) {
//                    previous = getPrevious(node);
//                    node.next = previous;
//                    node = node.next;
//                } else {
//                    node.next = null;
//                    node = null;
//                }
//            }
//        }
//
//        var temp = first;
//        first = last;
//        last = first;
    };

    public int getKthNodeFromEnd(int k) {
//        My Implementation - O(n)
//        if (k <= size && k > 0){
//            var node = first;
//            int count = size - k;
//            for (int i = 0; i < count ; i++) {
//                node = node.next;
//            }
//            return node.value;
//        } else return -1;

//       Mosh Implementation (without using size)
        if (isEmpty())
            throw new IllegalStateException();
        if (k > 0) {
            var ref1 = first;
            var ref2 = ref1.next;

            for (int i = 0; i < k-1 ; i++) {
                ref2 = ref2.next;
                if (ref2 == null)
                    throw new IllegalArgumentException();
            }

            while (ref2 != null) {
                ref1 = ref1.next;
                ref2 = ref2.next;
            }

            return ref1.value;
        } else return -1;
    };

    public void printMiddle() {
        // calc size
        // if odd -> get size%2 + 1 th node and if even get size%2th and size%2 + 1th element
        // My implementation

//        int length = 0;
//        var node = first;
//        while (node != null) {
//            length++;
//            node = node.next;
//        }
//        if (length > 0){
//            node = first;
//            if (length%2 == 0){
//                for (int i = 0; i < length/2 - 1 ; i++) {
//                    node = node.next;
//                }
//                System.out.println(node.value);
//                System.out.println(node.next.value);
//            } else {
//                for (int i = 0; i < length/2 ; i++) {
//                    node = node.next;
//                }
//                System.out.println(node.value);
//            }
//        }

        // Efficient Implementation - Space Complexity is Better
        if (isEmpty())
            throw new IllegalStateException();

        var ref1 = first;
        var ref2 = first;

        while (ref2 != last && ref2.next != last) {
            ref1 = ref1.next;
            ref2 = ref2.next.next;
        }

        if (ref2 == last){
            System.out.println(ref1.value);
        } else System.out.println(ref1.value + "," + ref1.next.value);
    };

    public void createWithLoop(int k) {
        if (k >= 0 && k < size){
            var node = first;
            for (int i = 0; i < k ; i++) {
                node = node.next;
            }

            last.next = node;
        } else throw new IllegalArgumentException();
    };

    public boolean hasLoop() {
        var ref1 = first;
        var ref2 = first;
        boolean hasLoop = false;

        while (ref2 != null && ref2.next != null) {
            ref1 = ref1.next;
            ref2 = ref2.next.next;

            if (ref1 == ref2){
                hasLoop = true;
                break;
            }
        }

        return hasLoop;
    };

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null){
            if(current.next == node)
                return current;
            current = current.next;
        }
        return null;
    };

    private boolean isEmpty(){
        return first == null;
    };
}
