package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
        arr[Objects.checkIndex(i, index)] = model;
    }

    public void remove(int i) {
        arr[Objects.checkIndex(i, index)] = null;
        index--;
        System.arraycopy(arr, i + 1, arr, i, index - i);
        arr[arr.length - 1] = null;
    }


    public T get(int position) {
        return (T) arr[Objects.checkIndex(position, index)];
    }

    @Override
    public Iterator<T> iterator() {
        int currentIndex = 0;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return currentIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) arr[index++];
            }
        };
    }
}
