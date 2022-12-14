package com.azamat.structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
    @Test
    public void testCreateList() {
        MyArrayList<Integer> list1 = new MyArrayList<Integer>();
        MyArrayList<Integer> list2 = new MyArrayList<Integer>(5);
        Object[] exceptedArray = new Object[]{};

        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty());
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals("[]", list1.toString());
        assertEquals("[]", list2.toString());
        assertArrayEquals(exceptedArray, list1.toArray());
        assertArrayEquals(exceptedArray, list2.toArray());
    }

    @Test
    public void testCreateFixedSizeList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>(5);
        Object[] exceptedArray = new Object[]{};

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
        assertArrayEquals(exceptedArray, list.toArray());
    }

    @Test
    public void testAddValuesToEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Object[] exceptedArray = new Object[]{1, 2};
        list.add(1);
        list.add(2);

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals("[1, 2]", list.toString());
        assertArrayEquals(exceptedArray, list.toArray());
    }

    /*
       By default, array inside list has length 10. So, If array size is 9, and you try
       to add new value to end of list it should be expanded.
     */
    @Test
    public void testExpandFullArray() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Object[] exceptedArray = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i=0; i<15; i++) {
            list.add(i);
        }

        assertEquals(15, list.size());
        assertArrayEquals(exceptedArray, list.toArray());
    }

    @Test
    public void testAddValuesToEndOfList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Object[] exceptedArray = new Object[]{1, 50, 3};
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 50);

        assertEquals(3, list.size());
        assertArrayEquals(exceptedArray, list.toArray());
    }

    @Test
    public void testAddValuesByIndexToList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Object[] exceptedArray = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i=1; i<=10; i++) {
            if (i == 2) {
                continue;
            }
            list.add(i); // 1, 3, 4 ... 9, 10
        }
        list.add(0, 0);
        list.add(2, 2);

        assertEquals(11, list.size());
        assertArrayEquals(exceptedArray, list.toArray());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnsuccessfulAddValuesToList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1, 100);

        assertTrue(list.isEmpty());
    }
}
