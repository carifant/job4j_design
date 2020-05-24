package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.length() == 0) {
                    line = reader.readLine();
                    continue;
                }
                if (line.contains("400") || line.contains("500")) {
                    String[] temp = line.split(" ");
                    out.print(temp[1] + "; ");
                    line = reader.readLine();
                    while (line != null && (!line.contains("200") || !line.contains("300"))) {
                        if (line.contains("200") || line.contains("300")) {
                            String[] temp2 = line.split(" ");
                            out.print(temp2[1] + System.lineSeparator());
                            break;
                        }
                        line = reader.readLine();
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("file.txt", "unavailable.csv");
    }
}