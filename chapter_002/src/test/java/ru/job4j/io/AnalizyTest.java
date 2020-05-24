package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void when1() {
        Analizy analizy = new Analizy();
        analizy.unavailable("C:\\projects\\job4j_design\\file.txt", "C:\\projects\\job4j_design\\unavailable.csv");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\job4j_design\\unavailable.csv"))) {
            String s = reader.readLine();
            while (s != null) {
                list.add(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        List<String> result = List.of("10:57:01; 10:59:01", "11:01:01; 11:02:01", "11:05:01; 11:06:01");
        assertThat(list, is(result));
    }
}