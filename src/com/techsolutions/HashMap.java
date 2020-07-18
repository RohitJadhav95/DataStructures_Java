package com.techsolutions;

import java.security.Key;

public class HashMap {

    private class KeyValue {
        private int key;
        private String value;

        private KeyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private KeyValue[] keyValueArray;
    private int count = 0;

    public HashMap(int capacity) {
        keyValueArray = new KeyValue[capacity];
    };

    public void put(int key, String value) {
        var pair = getPair(key);
        if (pair != null){
            pair.value = value;
            return;
        }

        if (isFull())
            throw new IllegalStateException();

        keyValueArray[hashFunction(key)] = new KeyValue(key, value);
        count++;
    };

    public String get(int key) {
        if (size() == 0)
            throw new IllegalStateException();

        int index = getIndex(key);
        return  index != -1 ? keyValueArray[index].value : null;
    };

    public int size() {
        return count;
    };

    public void remove(int key) {
        int index = getIndex(key);
        if (index == -1)
            throw new IllegalStateException();
        keyValueArray[index] = null;
        count--;
    };

    private boolean isFull() {
        return count >= keyValueArray.length;
    };

    private KeyValue getPair(int key) {
        int index = getIndex(key);
        return index != -1 ? keyValueArray[index] : null;
    };

    private int getIndex(int key) {
        int index = hashFunction(key);
        if (keyValueArray[index] == null)
            return -1;

        if (keyValueArray[index].key == key)
            return index;

        for (int i = 1; i < keyValueArray.length ; i++) {
            int index2 = hashFunction(index + i);
            if (keyValueArray[index2] == null)
                if (keyValueArray[index2].key == key)
                return index2;
        }

        return -1;
    };


    private int hashFunction(int key) {
        return key % keyValueArray.length;
    };
}
