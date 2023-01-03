package com.azamat.structures;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementsData;
    private int size;

    MyArrayList() {
        this.elementsData = createArray();
    }

    private Object[] createArray() {
        return new Object[this.DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isFull() {
        return this.size == this.elementsData.length;
    }

    private int newCapacity() {
        int oldCapacity = this.elementsData.length;
        return oldCapacity + (oldCapacity >> 1);
    }

    private void expandArray() {
        int newCapacity = newCapacity();
        this.elementsData = Arrays.copyOf(this.elementsData, newCapacity);
        System.arraycopy(elementsData, this.size, elementsData,
                 this.size+1, 0);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    private void removeByIndex(int index) {
        int newSize = --this.size;

        if (this.size > index) {
            System.arraycopy(this.elementsData, index + 1,
                this.elementsData, index,
                newSize - index);
        }

        this.elementsData[this.size] = null;

    }

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

    public void add(E element) {
        this.add(this.size, element);
    }

    public E get(int index) {
        checkIndex(index);
        return (E) this.elementsData[index];
    }

    /**
     * Remove element from list by value.
     */
    public void remove(E element) {
        int elementIndex = -1;

        for (int i=0; i<this.size; i++) {
            if (this.elementsData[i] == null && element == null) {
                elementIndex = i;
                break;
            }

            if (this.elementsData[i].equals(element)) {
                elementIndex = i;
                break;
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
