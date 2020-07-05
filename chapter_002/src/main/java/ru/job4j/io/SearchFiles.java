package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

public class SearchFiles extends SimpleFileVisitor<Path> {
    List<File> list = new ArrayList<>();
    String ext;

    public SearchFiles(String ext) {
        this.ext = ext;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        if (path.getFileName().toString().contains(ext)) {
            list.add(path.toFile());
        }
        return FileVisitResult.CONTINUE;
    }


}

