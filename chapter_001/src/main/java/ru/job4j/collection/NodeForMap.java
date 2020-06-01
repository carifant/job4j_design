package ru.job4j.collection;

import java.util.HashMap;
import java.util.Objects;

public class NodeForMap<K, V> {
    private final int hash;
    private final K key;
    private V value;


    NodeForMap(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;

    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NodeForMap<?, ?> that = (NodeForMap<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
