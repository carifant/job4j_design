package ru.job4j.collection;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenWeCreateMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(2, "two");
        String[] temp = {"one", "two", "three", "four", "five"};
        int result = temp.length;

        assertThat(result, is(map.size()));
    }

    @Test
    public void whenWeCreateMapAndDelite() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(2, "two");
        map.delete(3);
        String[] temp = {"one", "two", "four", "five"};
        int result = temp.length;
        assertThat(result, is(map.size()));
    }

    @Test
    public void whenWeCreateMapAndGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        String result = "five";
        assertThat(result, is(map.get(5)));
    }

}