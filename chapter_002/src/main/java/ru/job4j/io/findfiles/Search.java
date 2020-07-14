package ru.job4j.io.findfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        ValidArg ar = new ValidArg(args);
        SearchEngine searchFile = new SearchEngine();
        searchFile.writerOfResult(ar, searchFile.getFile(ar.getDirectory(), ar.getByMask(), ar));
    }
}


