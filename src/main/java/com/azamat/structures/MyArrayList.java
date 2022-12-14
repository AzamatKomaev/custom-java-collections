package com.azamat.structures;

import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] elementData;
    private int size = 0;
    final private int defaultCapacity = 10;

    /**
     * Default constructor: create array with default size 10.
     */
    MyArrayList() {
        this.elementData = createArray(defaultCapacity);
    }

    /**
     * Constructor with size: create array with entered size.
     */
    MyArrayList(int size) {
        this.elementData = createArray(size);
    }

    /**
     * Create array with fixed size.
     * @return Object[]
     */
    private Object[] createArray(int size) {
        return new Object[size];
    }

    /**
     * Check if elementData is empty.
     * If it has only null elements it returns true.
     * @return boolean
     */
    public boolean isEmpty() {
        for (Object element : this.elementData) {
            if (element != null) {
                return false;
            }
        }

        return true;
    }

    private boolean isFull() {
        return this.size == this.elementData.length;
    }

    /**
     * Calculate new size of elementData.
     * @return int
     */
    private int newCapacity() {
        int oldCapacity = this.elementData.length;
        return (int) Math.round(oldCapacity + (oldCapacity * 0.5));
    }

    /**
     * Expand array with +1 place.
     */
    private void expandArray() {
        int newCapacity = newCapacity();
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        System.arraycopy(elementData, this.size, elementData,
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
     * Remove element from elementData by index.
     */
    private void removeFromArray(int index) {
        int newSize = this.size - 1;

        if (this.size-1 > index) {
            System.arraycopy(this.elementData, index + 1,
                this.elementData, index,
                newSize - index);
        }

        this.size = newSize;
        this.elementData[this.size] = null;

    }

    /**
     * Add value to list by index.
     */
    public void add(int index, E element) {
        checkIndex(index);
        if (isFull()) {
            expandArray();
        }
        System.arraycopy(this.elementData, index,
                         this.elementData, index+1,
                   this.size - index);
        this.elementData[index] = element;
        this.size++;
    }

    /**
     * Add value to end of list.
     */
    public void add(E element) {
        checkIndex(this.size);
        if (isFull()) {
            expandArray();
        }
        this.elementData[this.size++] = element;
    }

    /**
     * Get value from list by index.
     * @return E
     */
    public E get(int index) {
        checkIndex(index);

        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        return (E) this.elementData[index];
    }

    /**
     * Remove element from list by value.
     */
    public void remove(Object element) {
        int elementIndex = -1;

        for (int i=0; i<this.size; i++) {
            if (this.elementData[i].equals(element)) {
                elementIndex = i;
            }
        }

        if (elementIndex == -1) {
            return;
        }

        removeFromArray(elementIndex);
    }

    /**
     * Remove element from list by index.
     */
    public void remove(int index) {
        checkIndex(index);
        removeFromArray(index);

    }

    /**
     * Get size of list.
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Convert list to array.
     * @return Object[]
     */
    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[]{};
        }

        Object[] resultArray = new Object[this.size];
        System.arraycopy(this.elementData, 0, resultArray, 0, this.size);
        return resultArray;
    }

    /**
     * Convert list to string.
     * @return String
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[" + this.elementData[0].toString());
        
        for (int i=1; i<this.elementData.length; i++) {
            if (this.elementData[i] == null) {
                continue;
            }
            result.append(", ").append(this.elementData[i]);
        }

        return result + "]";
    }
}
