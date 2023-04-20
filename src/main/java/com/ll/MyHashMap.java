package com.ll;

public class MyHashMap<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    public MyHashMap(){
        keys = new Object[0];
        values = new Object[0];
        size = 0;
    }

    public V put(K key, V value) {
        Object[] newKeys = new Object[size + 1];
        Object[] newValues = new Object[size + 1];

        for(int i = 0 ; i < size; i++) {
            if(keys[i].equals(key)){
                values[i] = value;
                return (V) Integer.valueOf(1);
            }
            newKeys[i] = keys[i];
        }
        for(int i = 0; i < size; i++)
            newValues[i] = values[i];
        newKeys[size] = key;
        newValues[size] = value;
        size++;

        keys = newKeys;
        values = newValues;

        return null;
    }

    public int size() {
        return size;
    }
}
