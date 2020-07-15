package ru.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ParserOfFiles {

    public static void main(String[] args) throws IOException, CsvException {
        new FileGeneration().generator(10, 3, "temp.cvs");
        Path start = Paths.get(".");
        List<String[]> list = new ParserOfFiles().storage(new Search().search(start, "cvs"));
        new ParserOfFiles().resultOfTask("result.cvs", list);
    }

    public List<String[]> storage(List<Path> root) throws IOException, CsvException {
        List<String[]> allRows = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < root.size(); i++) {
            try (CSVReader reader = new CSVReader(new FileReader(root.get(i).toFile()))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    String[] temp = nextLine[0].split(" ", 2);
                    int num = Integer.parseInt(temp[1]);
                    if (map.containsKey(num)) {
                        if (map.get(num) >= 20) {
                            continue;
                        }
                        map.put(num, map.get(num) + 1);
                        allRows.add(nextLine);
                    } else {
                        map.put(num, 1);
                        allRows.add(nextLine);
                    }
                }
            }
        }

        Collections.sort(allRows, new ComArray());
        return allRows;
    }

    public void resultOfTask(String out, List<String[]> list) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(out))) {
            for (int i = 0; i < list.size(); i++) {
                if (i >= 1000) {
                    break;
                }
                writer.writeNext(list.get(i));
            }
        }
    }
}

