package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                out.write("\n".getBytes());
                for (int j = 1; j <= 10; j++) {
                    int t =  i * j;
                    String temp =  String.valueOf(t);
                    String s = i + " * " + j + " = " + temp;
                    out.write(s.getBytes());
                    out.write("\n".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


