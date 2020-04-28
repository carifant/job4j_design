package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> tempIt = Collections.emptyIterator();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !tempIt.hasNext()) {
                    tempIt = it.next();
                }
                return tempIt.hasNext();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return tempIt.next();
                }
                throw new NoSuchElementException();
            }
        };

    }
}

