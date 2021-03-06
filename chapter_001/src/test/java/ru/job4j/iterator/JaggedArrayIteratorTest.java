package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class JaggedArrayIteratorTest {

    private Iterator<Integer> it;
    private Iterator<Integer> it2;

    @Before
    public void setUp() {
        it = new JaggedArrayIterator(new int[][]{{1}, {3, 4}, {7}});
        it2 = new JaggedArrayIterator(new int[][]{{1}, {2, 3, 4, 5}, {6, 7}, {8, 9, 10, 11, 12, 13, 14}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation2() {
        assertThat(it2.next(), is(1));
        assertThat(it2.next(), is(2));
        assertThat(it2.next(), is(3));
        assertThat(it2.next(), is(4));
        assertThat(it2.next(), is(5));
        assertThat(it2.next(), is(6));
        assertThat(it2.next(), is(7));
        assertThat(it2.next(), is(8));
        assertThat(it2.next(), is(9));
        assertThat(it2.next(), is(10));
        assertThat(it2.next(), is(11));
        assertThat(it2.next(), is(12));
        assertThat(it2.next(), is(13));
        assertThat(it2.next(), is(14));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void when4El() {
        int[][] in = {
                {1}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenFirstEmptyThenHashNext() {
        int[][] in = {
                {}, {1}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenEmpty() {
        int[][] in = {
                {}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        it.next();
    }

    @Test
    public void whenMultiHashNext() {
        int[][] in = {
                {}, {1}
        };
        JaggedArrayIterator it = new JaggedArrayIterator(in);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
}


