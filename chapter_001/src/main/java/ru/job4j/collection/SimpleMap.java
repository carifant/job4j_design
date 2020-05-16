package ru.job4j.collection;

import java.util.*;

public class SimpleMap<K, V> implements Iterable<V> {

    NodeForMap<K, V>[] table;
    private int size;
    private float loadFactor;
    private int modCount;


    public SimpleMap() {
        table = new NodeForMap[5];
        loadFactor = table.length * 0.75f;
    }

    private int position(K key) {
        int position = key.hashCode();
        position = position * 17;
        position = position % table.length;

        return position;
    }

    public int size() {
        return size;
    }

    boolean insert(K key, V value) {
        int i = position(key);
        if (size + 1 >= loadFactor) {
            loadFactor = loadFactor * 2;
            arrayDoubling();
        }
        if (table[i] != null) {
            return false;
        }
        table[i] = new NodeForMap<K, V>(i, key, value);
        size++;
        modCount++;
        return true;
    }

    public void arrayDoubling() {
        NodeForMap<K, V>[] oldTable = table;
        table = new NodeForMap[oldTable.length * 2];
        size = 0;
        modCount = 0;
        for (NodeForMap<K, V> n : oldTable) {
            if (n != null) {
                insert(n.getKey(), n.getValue());
            }
        }
    }

    V get(K key) {
        int i = position(key);
        if (table[i] == null) {
            System.out.println("Нет такого элемента");
            return null;
        }
        NodeForMap<K, V> n = table[i];
        if (key.equals(n.getKey())) {
            return n.getValue();
        }
        return null;
    }

    boolean delete(K key) {
        int i = position(key);
        if (table[i] == null) {
            return false;
        }
        if (table.length == 1) {
            table = null;
            size--;
            return true;
        }
        NodeForMap<K, V> n = table[i];
        if (key.equals(n.getKey())) {
            table[i] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return size == simpleMap.size &&
                Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterArray = 0;
            int tempModCount = modCount;

            @Override
            public boolean hasNext() {

                while (counterArray < table.length && table[counterArray] == null) {
                    counterArray++;
                }
                return counterArray < table.length;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != tempModCount) {
                    throw new ConcurrentModificationException();
                }
                return table[counterArray++].getValue();
            }
        };
    }
}
