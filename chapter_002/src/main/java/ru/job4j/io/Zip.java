package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static List<Path> search(Path root, List<String> ext) {
        List<Path> result = new ArrayList<>();
        SearchFiles sf;
        for (int i = 0; i < ext.size(); i++) {
            sf = new SearchFiles(ext.get(i));
            try {
                Files.walkFileTree(root, sf);
                result.addAll(sf.list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File search completed!");
        return result;
    }

    public List<File> getListOfFiles(String path, List<String> ext) {
        Path start = Paths.get(path);
        List<Path> listTemp = search(start, ext);
        List<File> fileListOfExsteptions = new ArrayList<>();
        for (Path x : listTemp) {
            fileListOfExsteptions.add(x.toFile());
        }
        File dir = new File(path);
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        for (int i = 0; i < fileListOfExsteptions.size(); i++) {
            for (int j = 0; j < lst.size(); j++) {
                if (lst.get(j).getName().contains(fileListOfExsteptions.get(i).getName())) {
                    lst.remove(j);
                }
            }
            // lst.removeAll(fileListOfExsteptions);
        }
        return lst;
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