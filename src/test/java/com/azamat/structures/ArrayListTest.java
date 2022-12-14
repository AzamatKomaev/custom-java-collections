package com.azamat.structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
    @Test
    public void testCreationEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
        assertArrayEquals(new Object[]{}, list.toArray());
    }

    @Test
    public void testCreationFixedSizeList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>(5);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
        assertArrayEquals(new Object[]{}, list.toArray());
    }
}
