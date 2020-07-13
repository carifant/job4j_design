package ru.job4j.io.findfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        ValidArg argZip = new ValidArg(args);
        try {
            List<Path> pathes = new SearchEngine().getListOfFiles(argZip);
            new SearchEngine().writerOfResult(argZip, pathes);
            for (Path p : pathes) {
                System.out.println(p.getFileName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

