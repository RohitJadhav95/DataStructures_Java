package com.techsolutions;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.LinkedList;

public class HashTable {

    private LinkedList<KeyValue>[] linkedListArray;

    public HashTable(int capacity) {
        linkedListArray = new LinkedList[capacity];
    };

    private class KeyValue {
        private int key;
        private String value;

        private KeyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, String value) {

        var list = getList(key);

        var pair = new KeyValue(key,value);

        if (list == null) {
            list = new LinkedList<KeyValue>();
        }
        for (var tempPair: list){
            if (tempPair.key == pair.key){
                tempPair.value = pair.value;
                return;
            }
        }

        list.add(pair);
        linkedListArray[hashFunction(key)] = list;
    };

    public String get(int key) {
        var pair = getKeyValue(key);

        if (pair != null)
            return pair.value;

        return null;
    };

    public String remove(int key) {
        var pair = getKeyValue(key);

        if (pair == null) throw new IllegalArgumentException();

        var value = pair.value;
        var list = getList(key);
        list.remove(pair);
        return value;
    };

    private LinkedList<KeyValue> getList(int key) {
        return linkedListArray[hashFunction(key)];
    };

    private KeyValue getKeyValue(int key) {
        var list = getList(key);
        if (list != null)
            for (var tempPair: list){
                if (tempPair.key == key){
                    return tempPair;
                } else continue;
            }
        return null;
    };

    private int hashFunction(int key) {
        return key % linkedListArray.length;
    };

    @Override
    public String toString() {
        return linkedListArray.toString();
    };
}
