package com.techsolutions;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    };

    public void enqueue(int item){
        if (count >= items.length) {
            var temp = new int[count*2];
            for (int i = 0; i < count ; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }

        var index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    };

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] <= item){
                items[i + 1] = items[i];
            } else break;
        }
        return i + 1;
    };

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        var item = items[count - 1];
        count--;
        return item;
    };

    public boolean isEmpty() {
      return count == 0;
    };
}

