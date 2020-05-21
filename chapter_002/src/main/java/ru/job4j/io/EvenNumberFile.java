package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int num = Integer.parseInt(line);
                if (num % 2 != 0) {
                    System.out.println("число " + num + " - нечетное");
                } else {
                    System.out.println("число " + num + " - четное");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

