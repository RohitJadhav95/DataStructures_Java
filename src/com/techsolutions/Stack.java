package com.techsolutions;

import java.util.Arrays;

public class Stack {
    private int [] stackArray = new int[1];
    private int count;

//    public Stack() {
//    };

    public void push(int item) {
        if (count >= stackArray.length){
            var temp = new int[2*count];
            for (int i = 0; i < count; i++) {
                temp[i] = stackArray[i];
            }
            stackArray = temp;
        }

        stackArray[count++] = item;
    };

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return stackArray[--count];
    };

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return stackArray[count - 1];
    };

    public boolean isEmpty() {
      return count == 0;
    };

    @Override
    public String toString() {
        var temp = Arrays.copyOfRange(stackArray, 0, count);
        return Arrays.toString(temp);
    };
}
