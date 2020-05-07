package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;
    private int modCount;

    public SimpleLinkedList() {
        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }

    public void add(E value) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(value);
        lstNode = new Node<E>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < Objects.checkIndex(index, size); i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            int tempModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != tempModCount) {
                    throw new ConcurrentModificationException();
                }
                return get(index++);
            }
        };
    }
}
