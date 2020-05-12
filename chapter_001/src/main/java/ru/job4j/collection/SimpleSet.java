package ru.job4j.collection;


import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> sa;

    public SimpleSet() {
        this.sa = new SimpleArray<T>();
    }

    public void add(T model) {
        if (sa.contains(model)) {
            return;
        }
        sa.add(model);
    }

    @Override
    public Iterator<T> iterator() {
        return sa.iterator();
    }
}








