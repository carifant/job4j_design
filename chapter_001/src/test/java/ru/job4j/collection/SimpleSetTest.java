package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void WhenAddForeElementsGetThreeElements() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("one");
        String[] set2 = new String[4];
        int index = 0;
        for (String s : set) {
            set2[index++] = s;
        }
        String[] result = {"one", "two", "three", null};
        assertThat(result, is(set2));
    }

}