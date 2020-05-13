package ru.job4j.collection;

import java.util.HashMap;

public class NodeForMap <K,V> {
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
}
