package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
            head = head.next;
    }

    public T get() {
        Node<T> tail = new Node<>(null, null);
        if (head != null) {
            tail = head;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.value;
    }

    public void deleteLast() {
        Node<T> tail;
        int count = 0;
        if (head != null) {
            tail = head;
            while (tail.next != null) {
                tail = tail.next;
                count++; // ввел переменную счётчик, чтобы понять сколько элементов в стеке
            }
            Node<T> temp;
            temp = head;
            for (int i = 0; i < count - 1; i++) { // ждём препоследнего элемента и удаляем его ссылку на последний элемент в стеке
                temp = temp.next;
            }
            temp.next = null;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}

