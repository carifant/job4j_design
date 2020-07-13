package ru.job4j.io.findfiles;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchEngine {

    public static List<Path> getListOfFiles(ValidArg arg) throws IOException {
        List<Path> result = new ArrayList<>();
        if (arg.include().startsWith("1")) {
            String temp = arg.include().substring(1);
            Pattern pattern = Pattern.compile(temp, Pattern.CASE_INSENSITIVE);
            Stream<Path> filesStream = Files.walk(Paths.get(arg.directory()));
            {
                filesStream.filter(path -> pattern.matcher(path.getFileName().toString()).find()).forEach(result::add);
                return result;
            }
        } else {
            SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().contains(arg.include()));
            Files.walkFileTree(Path.of(arg.directory()), searcher);
            return searcher.getPath();
        }
    }

    public static void writerOfResult(ValidArg arg, List<Path> pathes) {
        try (FileWriter fw = new FileWriter(arg.output())) {
            for (Path p : pathes) {
                fw.write("Найден следующий файл - " + p.getFileName() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}