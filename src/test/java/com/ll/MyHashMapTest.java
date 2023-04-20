package com.ll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testSize() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        assertEquals(3, map.size());
    }

    @Test
    void testPut() {
        assertNull(map.put("Key1", 1));
        assertEquals(1, map.size());
    }

    @Test
    void testPutReplace() {
        map.put("Key1", 1);
        assertEquals(Integer.valueOf(1), map.put("Key1", 2));
        assertEquals(1, map.size());
    }
}
