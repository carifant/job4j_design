package ru.job4j.collection;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void WhenWeCreateMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(2, "two");
        String[] result = {"one", "two", "three", "four", "five", null};
        String[] fromMap = new String[6];
        int i = 0;
        for (String s : map) {
            fromMap[i] = s;
            i++;
        }
        assertThat(result, is(fromMap));
    }

    @Test
    public void WhenWeCreateMapAndDelite() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(2, "two");
        map.delete(3);
        String[] result = {"one", "two", "four", "five", null};
        String[] fromMap = new String[5];
        int i = 0;
        for (String s : map) {
            fromMap[i] = s;
            i++;
        }
        assertThat(result, is(fromMap));
    }

    @Test
    public void WhenWeCreateMapAndGet() {
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