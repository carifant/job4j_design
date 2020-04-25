package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenArrayIterator implements Iterator {
    private int[] arr;
    private int index;
    Iterator<Integer> iterator = Collections.emptyIterator();

    public EvenArrayIterator(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        boolean temp = false;
        for (int i = index; i < arr.length; i++) {
            if (arr.length > index && arr[i] % 2 == 0) {
                temp = true;
                break;
            }
        }
        return temp;
    }

    @Override
    public Object next() {
        int temp = 0;
        if (index >= arr.length) {
            throw new NoSuchElementException();
        }
        if (arr[index] % 2 == 0) {
            temp = arr[index];
            index++;
            return temp;
        } else {
            index++;
            return next();
        }
    }
}
