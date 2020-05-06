package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T t = linked.get();
        linked.deleteLast();
        return t;
    }

    public void push(T value) {
        linked.add(value);
    }
}