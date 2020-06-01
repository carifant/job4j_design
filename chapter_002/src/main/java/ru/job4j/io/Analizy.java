package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line = reader.readLine();
            List<String> list = new ArrayList<>();
            while (line != null) {
                if (line.length() != 0) {
                    if (line.contains("400") || line.contains("500")) {
                        String[] temp = line.split(" ");
                        list.add(temp[1] + "; ");
                        line = reader.readLine();
                        while (line != null && (!line.contains("200") || !line.contains("300"))) {
                            if (line.contains("200") || line.contains("300")) {
                                String[] temp2 = line.split(" ");
                                list.add(temp2[1] + System.lineSeparator());
                                break;
                            }
                            line = reader.readLine();
                        }
                    }
                }
                line = reader.readLine();
            }
            ReaderList(list, target);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public void ReaderList(List<String> list, String target) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(target));
        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i));
        }
        out.close();
    }


    public static void main(String[] args) {
        new Analizy().unavailable("file.txt", "unavailable.csv");
    }
}