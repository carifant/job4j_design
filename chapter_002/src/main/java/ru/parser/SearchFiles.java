package ru.parser;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {

    private final List<Path> path = new LinkedList<>();
    private Predicate<Path> condition;

    public SearchFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        if (condition.test(path)) {
            this.path.add(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPath() {
        return path;
    }
}
