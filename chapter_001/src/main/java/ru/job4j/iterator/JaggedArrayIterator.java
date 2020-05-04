package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JaggedArrayIterator implements Iterator<Integer> {
    private final int[][] arr;
    private int row = 0;
    private int col = 0;

    public JaggedArrayIterator(int[][] x) {
        arr = x;
    }

    public boolean hasNext() {
        while (row < arr.length && arr[row].length == 0) {
            row++;
        }
        return row < arr.length && col < arr[row].length;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int temp = arr[row][col++];
        if (col == arr[row].length) {
            col = 0;
            row++;
        }
        return temp;
    }
}
