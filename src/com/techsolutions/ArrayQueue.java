package com.techsolutions;

import java.util.Arrays;
import java.util.Stack;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int end;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    };

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();

        items[end] = item;
        end = (end + 1) % items.length;
        count++;
    };

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        var item = items[front];
        count--;
        front = (front + 1) % items.length;
        return item;
    };

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        return items[front];
    };

    public boolean isEmpty() {
        return count == 0;
    };

    public boolean isFull(){
        return count == items.length;
    };

    @Override
    public String toString() {
        return Arrays.toString(items);
    };
}






