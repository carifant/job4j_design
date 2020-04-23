package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenArrayIteratorTest {

    private Iterator<Integer> it;
    private Iterator<Integer> it2;

    @Before
    public void setUp() {
        it = new EvenArrayIterator(new int[]{1, 3, 4, 7});
        it2 = new EvenArrayIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
    }

    @Test
    public void testsThatNextMethodWillFour() {
        assertThat(it.next(), is(4));
    }

    @Test
    public void testsThatNextMethodWillEvenNumbers() {
        assertThat(it2.next(), is(2));
        assertThat(it2.next(), is(4));
        assertThat(it2.next(), is(6));
        assertThat(it2.next(), is(8));
        assertThat(it2.next(), is(10));
        assertThat(it2.next(), is(12));
        assertThat(it2.next(), is(14));

    }

    @Test
    public void hasNextAndHasNextIsWork() {
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(2));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(4));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(6));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(8));
        assertThat(it2.hasNext(), is(true));
        it2.next();
        it2.next();
        it2.next();
        assertThat(it2.hasNext(), is(false));
    }
}

