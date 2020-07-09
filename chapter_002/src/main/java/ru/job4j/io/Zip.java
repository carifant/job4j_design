package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static List<Path> getListOfFiles(ArgZip argZip) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()));
        Files.walkFileTree(Path.of(argZip.directory()), searcher);
        return searcher.getPath();
    }

    public void packFiles(List<Path> sources, File target, String direct) {
        //List<File> list = new ArrayList<>();
//        for (int i = 0; i < sources.size(); i++) {
//            list.add(sources.get(i).toFile());
//            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
//                zip.putNextEntry(new ZipEntry(list.get(i).getName()));
//                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(list.get(i)))) {
//                    zip.write(out.readAllBytes());
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        for (int i = 0; i < sources.size(); i++) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(sources.get(i).toFile().getAbsolutePath().substring(direct.length() + 1)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sources.get(i).toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        List<Path> listOfPath = null;
        try {
            listOfPath = new Zip().getListOfFiles(argZip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Zip().packFiles(listOfPath, new File(argZip.output()), argZip.directory());

    }
}