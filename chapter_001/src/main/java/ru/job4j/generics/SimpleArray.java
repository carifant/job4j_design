package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int index;
    private Object[] arr;

    public SimpleArray(int size) {
        arr = new Object[size];
    }

    public void add(T model) {
        arr[index++] = model;
    }

    public void set(int i, T model) {
        int temp = Objects.checkIndex(i, arr.length);
        arr[temp] = model;
    }

    public void remove(int i) {
        int temp = Objects.checkIndex(i, arr.length);
        arr[temp] = null;
        for (int j = temp; j + 1 < arr.length; j++) {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = null;
    }


    public T get(int position) {
        int temp = Objects.checkIndex(position, arr.length);
        return (T) arr[temp];
    }

    @Override
    public Iterator<T> iterator() {
        int currentIndex = 0;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return currentIndex < arr.length && arr[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }
}
