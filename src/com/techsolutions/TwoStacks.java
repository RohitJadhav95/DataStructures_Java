package com.techsolutions;

import java.util.Arrays;

public class TwoStacks {
    private int [] items;
    private int count1;
    private int count2;

    public TwoStacks(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0");

        items = new int[capacity];
        count2 = capacity;
    };
    public void push1(int item) {
        if (isFull()) throw new IllegalStateException();

        items[count1++] = item;
    };

    public int pop1() {
        if (isEmpty1()) throw new IllegalStateException();

        return items[--count1];
    };

    public boolean isEmpty1() {
        return count1 == 0;
    };

    public String toString1() {
        if (isEmpty1()) return null;

        var temp = Arrays.copyOfRange(items, 0, count1);
        return Arrays.toString(temp);
    };

    public void push2(int item) {
        if(isFull()) throw new IllegalStateException();

        items[--count2] = item;
    }

    public int pop2() {
        if (isEmpty2()) throw new IllegalStateException();

        return items[count2++];
    };

    public boolean isEmpty2() {
      return count2 == items.length;
    };

    public String toString2() {
        if (isEmpty2()) return null;

        var temp = Arrays.copyOfRange(items, count2, items.length);
        return Arrays.toString(temp) ;
    };

    public boolean isFull() {
        return count1 == count2;
    };
}
