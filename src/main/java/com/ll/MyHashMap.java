package com.ll;

public class MyHashMap<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    public MyHashMap() {
        keys = new Object[0];
        values = new Object[0];
        size = 0;
    }

    public V put(K key, V value) {
        Object[] newKeys = new Object[size + 1];
        Object[] newValues = new Object[size + 1];

        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return (V) Integer.valueOf(1);
            }
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

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

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }

        return null;
    }

    public V remove(K key) {
        if(isEmpty())
            return null;

        Object[] newKeys = new Object[size - 1];
        Object[] newValues = new Object[size - 1];

        V previous = null;
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                index = i;
                previous = (V) values[index];
                break;
            }
        }

        if (previous == null)
            return null;

        for (int i = 0; i < index; i++) {
            if (keys[i].equals(key)) {
                break;
            }
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        for (int i = index + 1; i < size; i++) {
            newKeys[i - 1] = keys[i];
            newValues[i - 1] = values[i];
        }

        keys = newKeys;
        values = newValues;
        size--;

        return previous;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        keys = new Object[0];
        values = new Object[0];
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0 || keys == null && values == null)
            return true;

        return false;
    }
}
