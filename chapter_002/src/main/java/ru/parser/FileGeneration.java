package ru.parser;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class FileGeneration {

    public void generator(int countOfLine, int countOfFile, String path) {
        for (int i = 0; i < countOfFile; i++) {
            String nameOfFile = i + path;
            try (CSVWriter writer = new CSVWriter(new FileWriter(nameOfFile))) {
                for (int j = 0; j < countOfLine; j++) {
                    double random = Math.random() * 10000;
                    int rand = (int) (Math.random() * 100 + 31);
                    String formattedDouble = new DecimalFormat("#0.00").format(random);
                    String temp = "ID " + rand + ", Product Name, Product Condition, Product State," + formattedDouble;
                    String[] record = temp.split(",", 5);
                    writer.writeNext(record);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


