package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenArrayIterator implements Iterator {
    private int[] arr;
    private int index;

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
        try {
            for (int i = index; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    temp = arr[i];
                    index++;
                    break;
                }
                index++;
            }
        } catch (NoSuchElementException e) {
            System.out.println("отсутствуют элементы к возврату");
        }
        return temp;
    }
}
