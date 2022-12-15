package com.azamat.structures;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int defaultCapacity = 10;
    private Object[] elementsData;
    private int size = 0;


    /**
     * Default constructor: create array with default size 10.
     */
    MyArrayList() {
        this.elementsData = createArray();
    }

    /**
     * Create array with fixed size.
     * @return Object[]
     */
    private Object[] createArray() {
        return new Object[this.defaultCapacity];
    }

    /**
     * Check if elementsData is empty.
     * If it has only null elements it returns true.
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isFull() {
        return this.size == this.elementsData.length;
    }

    /**
     * Calculate new size of elementsData.
     * @return int
     */
    private int newCapacity() {
        int oldCapacity = this.elementsData.length;
        return oldCapacity + (oldCapacity >> 1);
    }

    /**
     * Expand array with +1 place.
     */
    private void expandArray() {
        int newCapacity = newCapacity();
        this.elementsData = Arrays.copyOf(this.elementsData, newCapacity);
        System.arraycopy(elementsData, this.size, elementsData,
                 this.size+1, 0);
    }

    /**
     * Check if index is valid.
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    /**
     * Remove element from elementsData by index.
     */
    private void removeByIndex(int index) {
        int newSize = --this.size;

        if (this.size > index) {
            System.arraycopy(this.elementsData, index + 1,
                this.elementsData, index,
                newSize - index);
        }

        this.elementsData[this.size] = null;

    }

    /**
     * Add value to list by index.
     */
    public void add(int index, E element) {
        checkIndex(index);
        if (isFull()) {
            expandArray();
        }
        System.arraycopy(this.elementsData, index,
                         this.elementsData, index+1,
                   this.size - index);
        this.elementsData[index] = element;
        this.size++;
    }

    /**
     * Add value to end of list.
     */
    public void add(E element) {
        this.add(this.size, element);
    }

    /**
     * Get value from list by index.
     * @return E
     */
    public E get(int index) {
        checkIndex(index);

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        return (E) this.elementsData[index];
    }

    /**
     * Remove element from list by value.
     */
    public void remove(E element) {
        int elementIndex = -1;

        for (int i=0; i<this.size; i++) {
            if (this.elementsData[i].equals(element)) {
                elementIndex = i;
            }
        }

        if (elementIndex == -1) {
            return;
        }

        removeByIndex(elementIndex);
    }

    /**
     * Remove element from list by index.
     */
    public void remove(int index) {
        checkIndex(index);
        removeByIndex(index);
    }

    /**
     * Get size of list.
     * @return int
     */
    public int size() {
        return this.size;
    }
}
