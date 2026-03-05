package com.user.main;

class MyArrayList<T> {

    private Object[] arr;
    private int size;
    private int capacity;

    public MyArrayList() {
    	System.out.println("Inside MyArrayList Class");
        capacity = 10;
        arr = new Object[capacity];
        size = 0;
    }

    // Add element
    public void add(T value) {
        if (size == capacity) {
            resize();
        }
        arr[size++] = value;
    }

    // Get element
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return (T) arr[index];
    }

    // Remove element
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[size - 1] = null; // avoid memory leak
        size--;
    }

    // Resize method
    private void resize() {
        capacity = capacity * 2;
        Object[] newArr = new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Size
    public int size() {
        return size;
    }
}