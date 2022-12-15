package com.azamat.structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
    @Test
    public void testCreateList() {
        MyArrayList<User> list1 = new MyArrayList<User>();

        assertTrue(list1.isEmpty());
        assertEquals(0, list1.size());
    }

    @Test
    public void testAddValuesToEmptyList() {
        MyArrayList<User> list = new MyArrayList<User>();
        User[] usersList = {
            new User("Azamat", "Komaev", 16),
            new User("Dima", "Maslo", 23)
        };
        for (User user : usersList) {
            list.add(user);
        }

        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(usersList[0], list.get(0));
        assertEquals(usersList[1], list.get(1));
    }

    /*
       By default, array inside list has length 10. So, If array size is 9, and you try
       to add new value to end of list it should be expanded.
     */
    @Test
    public void testExpandFullArray() {
        MyArrayList<String> list = new MyArrayList<String>();
        // 12 elements
        String[] names = {
            "Azamat", "David", "Vladimir", "Dmitry", "Sasha", "Alex",
            "Petr", "Aaron", "Abby", "Abe", "Joy", "Judd"
        };
        for (String name : names) {
            list.add(name);
        }

        assertEquals(12, list.size());
        for (int i=0; i<list.size(); i++) {
            assertEquals(names[i], list.get(i));
        }
    }

    @Test
    public void testAddValuesToEnd() {
        MyArrayList<User> list = new MyArrayList<User>();
        User[] usersList = {
            new User("Azamat", "Komaev", 16),
            new User("Sasha", "Medvedev", 25),
            new User("Vladimir", "Zaharov", 11),
            new User("Nicolay", "Menshevikov", 52)
        };

        list.add(usersList[0]);
        list.add(usersList[2]);
        list.add(usersList[3]);
        list.add(1, usersList[1]);
        assertEquals(4, list.size());
        for (int i=0; i<list.size(); i++) {
            assertEquals(usersList[i], list.get(i));
        }
    }

    @Test
    public void testAddValuesByIndex() {
        MyArrayList<String> list = new MyArrayList<String>();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "l", "j", "z"}; // 11 elements

        for (int i=1; i<letters.length; i++) {
            if (i == 2) {
                continue;
            }
            list.add(letters[i]); // b, d, ... l, j
        }
        list.add(0, letters[0]);
        list.add(2, letters[2]);

        assertEquals(11, list.size());
        for (int i=0; i<list.size(); i++) {
            assertEquals(letters[i], list.get(i));
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnsuccessfulAddValues() {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add(1, "Azamat"); // Index out of range

        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetValue() {
        MyArrayList<User> list = new MyArrayList<User>();
        User[] usersList = {
            new User("Azamat", "Komaev", 16),
            new User("Vasya", "Johnson", 23),
            new User("Antosha", "Antoshovich", 12)
        };
        list.add(usersList[0]);
        list.add(usersList[1]);
        list.add(usersList[2]);

        assertEquals(usersList[0], list.get(0));
        assertEquals(usersList[1], list.get(1));
        assertEquals(usersList[2], list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnsuccessfulGetValue() {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("Azamat");
        list.add("Vladimir");
        list.get(3); // Index out of range
    }

    @Test
    public void testRemoveElement() {
        MyArrayList<User> list = new MyArrayList<User>();
        User[] usersList = {
            new User("Azamat", "Komaev", 16),
            new User("Vasya", "Johnson", 23),
            new User("Antosha", "Antoshovich", 12),
            new User("Alex", "Gordon", 62)
        };
        for (User user : usersList) {
            list.add(user);
        }
        assertEquals(4, list.size());

        list.remove(1);
        list.remove(usersList[2]);

        assertEquals(2, list.size());
        assertEquals(usersList[0], list.get(0));
        assertEquals(usersList[3], list.get(1));
    }
}
