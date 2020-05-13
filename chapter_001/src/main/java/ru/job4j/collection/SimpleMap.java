package ru.job4j.collection;

import java.util.*;

public class SimpleMap<K, V> implements Iterable<V> {

    NodeForMap<K, V>[] table;
    private int index;

    public SimpleMap() {
        table = new NodeForMap[5];
    }

    private int position(K key) {
        int position = key.hashCode();
        while (position > table.length) {
            position = position / 3;
        }
        return position;
    }

    boolean insert(K key, V value) {
        int i = position(key);
        if (index >= table.length) {
            table = Arrays.copyOf(table, table.length * 2);
        }
        if (table[i - 1] != null) {
            return false;
        }
        table[i - 1] = new NodeForMap<K, V>(i, key, value);
        index++;
        return true;
    }

    V get(K key) {
        int i = position(key);
        if (table[i - 1] == null) {
            System.out.println("Нет такого элемента");
            return null;
        }
        return table[i - 1].getValue();
    }

    boolean delete(K key) {
        int i = position(key);
        if (table[i - 1] == null) {
            return false;
        }
        table[i - 1] = null;
        index--;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return index == simpleMap.index &&
                Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterArray = 0;

            @Override
            public boolean hasNext() {

                while (table[counterArray] == null && counterArray < table.length) {
                    counterArray++;
                    if (counterArray == table.length) {
                        return false;
                    }
                }
                return counterArray < table.length;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[counterArray++].getValue();
            }
        };
    }
}
