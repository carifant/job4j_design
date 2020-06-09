package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader2 = new BufferedReader(new FileReader("text.txt"))) {
            boolean b = true;
            List<String> dialog = new ArrayList<>();
            List<String> copyOfFile = new ArrayList<>();
            String s;
            while (reader2.ready()) {
                s = reader2.readLine();
                copyOfFile.add(s);
            }
            String phrase;
            String answer;
            while (b) {
                phrase = reader.readLine();
                dialog.add(phrase);
                if (phrase.contains("закончить")) {
                    break;
                } else if (phrase.contains("стоп")) {
                    while (!phrase.contains("продолжить")) {
                        phrase = reader.readLine();
                        dialog.add(phrase);
                        if (phrase.contains("закончить")) {
                            b = false;
                            break;
                        }
                    }
                }
                if (phrase.contains("закончить")) {
                    break;
                }
                answer = copyOfFile.get((int) (Math.random() * copyOfFile.size()));
                dialog.add(answer);
                System.out.println(answer);
            }
            for (String x : dialog) {
                System.out.println(x);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
