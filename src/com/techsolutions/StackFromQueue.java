package com.techsolutions;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackFromQueue {

    private Queue<Integer> items = new ArrayDeque<>();
    private Queue<Integer> sortedItems = new ArrayDeque<>();
    private int count;

    public void push(int item) {
        items.add(item);
        count++;
    };

    public int pop() {
       if(isEmpty()) throw new IllegalStateException();

       sort();
       count--;
       return sortedItems.remove();
    };

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        return sortedItems.peek();
    };

    public int size() {
        return count;
    };

    public boolean isEmpty() {
        return sortedItems.isEmpty() && items.isEmpty();
    };

    private void sort() {
        if (sortedItems.isEmpty()){
            while (!items.isEmpty()) {
                sortedItems.add(items.remove());
            }
        }
    };

    @Override
    public String toString() {
        return sortedItems.toString();
    };


}


