package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int size = 0;

    public T poll() {
        SimpleStack<T> x = in;
        SimpleStack<T> temp = in;
        int i = 0;
        while (i < size) {
            T t = in.pop();
            out.push(t);
            i++;
        }
        size--;
        return out.pop();
    }

    public void push(T value) {
        size++;
        in.push(value);

    }
}