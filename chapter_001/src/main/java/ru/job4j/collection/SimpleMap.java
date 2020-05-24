package ru.job4j.collection;

import java.util.*;

public class SimpleMap<K, V> implements Iterable<V> {

    NodeForMap<K, V>[] table;
    private int size;
    private final float loadFactor;
    private int modCount;


    public SimpleMap() {
        table = new NodeForMap[5];
        loadFactor = 0.75f;
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

        if (size >= table.length * loadFactor) {
            arrayDoubling();
        }
        int i = position(key);
        if (table[i] != null && table[i].getKey().equals(key)) {
            table[i].setValue(value);
            modCount++;
            return true;
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
        NodeForMap<K, V> n = table[i];
        if (key.equals(n.getKey())) {
            table[i] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return Float.compare(simpleMap.loadFactor, loadFactor) == 0 &&
                Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(loadFactor);
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
