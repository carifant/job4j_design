package ru.job4j.io;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        search(start, "glob:*.txt").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) {
        SearchFiles sf = new SearchFiles(ext);
        try {
            Files.walkFileTree(root, sf);
            System.out.println("File search completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sf.list;
    }
}
