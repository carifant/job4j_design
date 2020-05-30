package ru.job4j.collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq2("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq2("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq2("heloo", "hello"), is(false));
    }

}