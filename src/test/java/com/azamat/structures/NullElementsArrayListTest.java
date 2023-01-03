package com.azamat.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NullElementsArrayListTest {
    private MyArrayList<Object> list;

    @Before
    public void after() {
        list = new MyArrayList<>(); // clear list before each test
    }

    @Test
    public void testAddNullValuesToEmptyList() {
        list.add(null);
        list.add(null);

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertNull(list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void testExpandFullArrayWithNullValues() {
        for (int i=0; i<12; i++) {
            list.add(null);
        }

        assertEquals(12, list.size());
        for (int i=0; i<list.size(); i++) {
            assertNull(list.get(i));
        }
    }

    @Test
    public void testAddNullValuesToEnd() {
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(1, null);

        assertEquals(4, list.size());
        for (int i=0; i<list.size(); i++) {
            assertNull(list.get(i));
        }
    }

    @Test
    public void testAddNullValuesByIndex() {
        for (int i=0; i<4; i++) {
            list.add(null);
        }
        list.add(1, null);
        list.add(2, null);

        assertEquals(6, list.size());
        for (int i=0; i<6; i++) {
            assertNull(list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnsuccessfulAddNullValues() {
        list.add(1, null);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetNullValues() {
        list.add(null);
        list.add(null);
        list.add(null);

        assertNull(list.get(0));
        assertNull(list.get(1));
        assertNull(list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnsuccessfulGetNullValues() {
        list.add(null);
        list.add(null);
        list.get(3);
    }

    @Test
    public void testRemoveNullElements() {
        for (int i=0; i<5; i++) {
            list.add(null);
        }
        assertEquals(5, list.size());

        list.remove(null);
        assertEquals(4, list.size());

        list.remove(4);
        assertEquals(3, list.size());
    }
}
