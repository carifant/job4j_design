package ru.job4j.collection;


import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int modCount;
    private int index;
    private Object[] arr = new Object[10];

    public void add(T model) {
        if (index >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2 + 1);
        }
        arr[index++] = model;
        modCount++;
    }

    public boolean contains(T model) {
        for (int i = 0; i < index; i++) {
            if (arr[i].equals(model)) {
                return true;
            }
        }
        return false;
    }

    public void set(int i, T model) {
        arr[Objects.checkIndex(i, index)] = model;
    }

    public void remove(int i) {
        arr[Objects.checkIndex(i, index)] = null;
        index--;
        System.arraycopy(arr, i + 1, arr, i, index - i);
        arr[arr.length - 1] = null;
        modCount++;
    }

    public T get(int position) {
        return (T) arr[Objects.checkIndex(position, index)];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            int tempModCount = modCount;

            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != tempModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) arr[i++];
            }
        };
    }
}