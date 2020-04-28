package ru.job4j.iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConverterTest {

    Iterator<Integer> it;

    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(1));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(2));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(3));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(4));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(7));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(8));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(9));
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        Assert.assertThat(it.next(), is(1));
        Assert.assertThat(it.next(), is(2));
        Assert.assertThat(it.next(), is(3));
        Assert.assertThat(it.next(), is(4));
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.next(), is(7));
        Assert.assertThat(it.next(), is(8));
        Assert.assertThat(it.next(), is(9));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(1));
        Assert.assertThat(it.next(), is(2));
        Assert.assertThat(it.next(), is(3));
        Assert.assertThat(it.next(), is(4));
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.next(), is(7));
        Assert.assertThat(it.next(), is(8));
        Assert.assertThat(it.next(), is(9));
    }

    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        Iterator<Integer> it1 = Collections.emptyIterator();
        Iterator<Integer> it2 = Collections.emptyIterator();
        Iterator<Integer> it3 = Collections.emptyIterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        Assert.assertThat(it.next(), is(1));
        Assert.assertThat(it.next(), is(2));
        Assert.assertThat(it.next(), is(3));
        it.next();
    }

    @Test
    public void whenNeedSkipEmptyIterators() {
        Iterator<Integer> it1 = Collections.emptyIterator();
        Iterator<Integer> it2 = Collections.emptyIterator();
        Iterator<Integer> it3 = Arrays.asList(1).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        Assert.assertThat(it.next(), is(1));
    }
}

