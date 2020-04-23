package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JaggedArrayIterator implements Iterator {
    List<Integer> iterator = new ArrayList<>();
    int index = 0;

    public JaggedArrayIterator(int[][] x) {
        for (int[] temp : x) {
            for (int i : temp) {
                iterator.add(i);
            }
        }
    }

    public boolean hasNext() {
        return index < iterator.size();
    }

    public Object next() {
        int temp = iterator.get(index);
        index++;
        return temp;
    }

    public void remove() {
    }
}
