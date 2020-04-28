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
        for (int i = row; i < arr.length; i++) {
            if (arr[i] != null) {
                if (col == arr[row].length) {
                    col = 0;
                    row++;
                    return hasNext();
                }
                if (col <= arr[i].length) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer next() {
        if (row >= arr.length) {
            throw new NoSuchElementException();
        }
        if (col == arr[row].length) {
            col = 0;
            row++;
            return next();
        }
        if (arr[row] == null) {
            row++;
            return next();
        }
        return arr[row][col++];
    }
}
