package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.Iterator;

public class SimpleSet<T> extends SimpleArray<T> implements Iterable<T> {

    int index = 0;

    public void add(T model) {
        for (int i = 0; i < index; i++) {
            if (super.get(i).equals(model)) {
                return;
            }
        }
        super.add(model);
        index++;
    }
}
