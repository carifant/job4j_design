package ru.parser;

import java.util.Comparator;

public class ComArray implements Comparator<String[]> {

    @Override
    public int compare(String[] o1, String[] o2) {
        return o1[4].compareTo(o2[4]);
    }
/*
    @Override
    public int compare(String[] o1, String[] o2) {
        int temp = Integer.parseInt(o1[4]);
        int temp2 = Integer.parseInt(o2[4]);
        return temp - temp2;
    }
    */

}
