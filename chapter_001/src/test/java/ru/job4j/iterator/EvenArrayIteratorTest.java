package ru.job4j.iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenArrayIteratorTest {

    private Iterator<Integer> it;
    private Iterator<Integer> it2;
    private Iterator<Integer> it3;

    @Before
    public void setUp() {
        it = new EvenArrayIterator(new int[]{1, 3, 4, 7});
        it2 = new EvenArrayIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        it3 = new EvenArrayIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
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
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Assert.assertThat(it3.hasNext(), is(true));
        Assert.assertThat(it3.next(), is(2));
        Assert.assertThat(it3.hasNext(), is(true));
        Assert.assertThat(it3.next(), is(4));
        Assert.assertThat(it3.hasNext(), is(true));
        Assert.assertThat(it3.next(), is(6));
        Assert.assertThat(it3.hasNext(), is(false));
        it3.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Assert.assertThat(it3.hasNext(), is(true));
        Assert.assertThat(it3.hasNext(), is(true));
        Assert.assertThat(it3.next(), is(2));
        Assert.assertThat(it3.next(), is(4));
        Assert.assertThat(it3.next(), is(6));
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenArrayIterator(new int[]{1});
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenArrayIterator(new int[] {2, 4, 6, 8});
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(2));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(4));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(8));
    }
}

