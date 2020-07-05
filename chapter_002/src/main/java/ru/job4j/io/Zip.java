package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public List<File> getListOfFiles(String path, List<String> ext) {
        List<File> rsl = new ArrayList();
        File file = new File(path);
        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory()) {
                String name = el.getName();
                if (name.contains(".")) {
                    if (!ext.contains(name.substring(name.indexOf(".")))) {
                        rsl.add(el);
                    }
                }
            } else {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return rsl;
    }

    public void packFiles(List<File> sources, File target) {
        for (int i = 0; i < sources.size(); i++) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(sources.get(i).getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(target))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Архивация прошла успешно");
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
        List<File> listOfFiles = new Zip().getListOfFiles(argZip.directory(), argZip.exclude());
        new Zip().packFiles(listOfFiles, new File(argZip.output()));

    }
}