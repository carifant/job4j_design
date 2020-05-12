package ru.job4j.collection;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleSet<T> implements Iterable<T> {
    SimpleArray<T> sa;

    public SimpleSet() {
        this.sa = new SimpleArray<T>();
    }

    public void add(T model) {
        if (sa.contains(model)) {
            return;
        }
        sa.add(model);
    }

    public T get(int index) {
        return sa.get(index);
    }

        @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return sa.iterator().hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return sa.iterator().next();
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleSet{" +
                "sa=" + sa +
                '}';
    }
        }







