package ru.job4j.collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int modCount;
    private int index;
    private Object[] arr = new Object[10];
    Object[] newArr;

    public void add(T model) {
        if (index >= arr.length) {
            newArr = new Object[arr.length * 2 + 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[index++] = model;
        modCount++;
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