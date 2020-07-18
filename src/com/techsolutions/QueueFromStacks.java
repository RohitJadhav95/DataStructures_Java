package com.techsolutions;

import java.util.Stack;

public class QueueFromStacks {
    private Stack<Integer> items = new Stack<>();
    private Stack<Integer> sortItems = new Stack<>();

    public void enqueue(int item) {
        items.push(item);
    };

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        sort();
        return sortItems.pop();
    };

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        sort();
        return sortItems.peek();
    };

    @Override
    public String toString() {
        sort();
        return sortItems.toString();
    };

    public boolean isEmpty() {
      return sortItems.isEmpty() && items.isEmpty();
    };

    private void sort() {
        if (sortItems.isEmpty()){
            while (!items.isEmpty()) {
                sortItems.push(items.pop());
            }
        }
    };
}

