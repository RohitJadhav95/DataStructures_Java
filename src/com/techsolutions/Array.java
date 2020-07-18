package com.techsolutions;

import java.util.ArrayList;

public class Array{
    private int length;
    private int[] items;
    int count = 0;

    public Array(int length){
        items = new int[length];
    }

    public void insert(int item){
        if(count == items.length){
            int [] temp = items;
            this.items = new int[2*count];
            for (int i = 0; i < count; i++) {
                items[i] = temp[i];
            }
        }
        items[count++] = item;
        return;
    };

    public int indexOf(int item){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    };

    public void removeAt(int index){
        if(index >= count || index < 0){
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count - 1; i++) {
            items[i] = items[i+1];
        }
        count --;
        return;
    };

    public int max(){
        int max = 0;
        for (int i = 0; i < count; i++) {
            if(items[i] > max){
                max = items[i];
            }
        }
        return max;
    };

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items) {
            if (other.indexOf(item) >= 0){
                intersection.insert(item);
            }
        }
        return intersection;
    };

    public void reverse(){
      int [] temp = new int[count];

      for (int i = 0; i < count ; i++) {
            temp[count - i - 1] = items[i];
      }

      items = temp;
    };

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        if(count == items.length){
            int [] temp = items;
            this.items = new int[2*count];
            for (int i = 0; i < count; i++) {
                items[i] = temp[i];
            }
        }

        for (int i = 0; i < count; i++) {
            if (i == index){
                items[i] = item;
                count++;
            } else if (i > index) {
                items[i + 1] = items [i];
            }
        }


    };

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    };


}