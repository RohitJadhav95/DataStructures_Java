package com.techsolutions;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> items = new Stack<>();
    private Stack<Integer> sortedMin = new Stack<>();
    private int min;

    public void push(int item) {
        if (item <= min || isEmpty()) {
            min = item;
            sortedMin.push(min);
        }
        items.push(item);
    };

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();

        var topItem = items.pop();
        if (topItem == min) {
            sortedMin.pop();
            min = sortedMin.peek();
        }
        return topItem;
    };

    public void printMin() {
      System.out.println(min);
    };

    private boolean isEmpty() {
        return items.empty();
    };

}
