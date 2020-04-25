package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JaggedArrayIterator implements Iterator {
    int[][] arr;
    int row = 0;
    int col = 0;

    public JaggedArrayIterator(int[][] x) {
        arr = x;
    }

    public boolean hasNext() {
        boolean b = false;
        while (row < arr.length) {
            b = true;
            break;
        }
        return b;
    }

    public Object next() {
        int temp = arr[row][col];
        col++;
        if (col == arr[row].length) {
            col = 0;
            row++;
        }
        return temp;
    }

}
