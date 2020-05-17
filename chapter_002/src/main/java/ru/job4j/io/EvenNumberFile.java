package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int result = in.read();
            char content;
            while (result != -1) {
               content = (char) result;
               String s = Character.toString(content);
                   int i = Integer.parseInt(s);
                   if (i % 2 == 0) {
                       System.out.println("число четное");
                   }
                result = in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

