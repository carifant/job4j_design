package ru.job4j.io.findfiles;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    File target = null;

    public File getFile(String root, String ext, ValidArg arg) {
        Queue<File> data = new LinkedList<>();
        File file = new File(root);
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File listFile : Objects.requireNonNull(el.listFiles())) {
                    data.offer(listFile);
                }
            }
            if (el.isFile()) {
                searchByCriteria(el, ext, arg);
                if (target != null) {
                    break;
                }
            }
        }
        return target;
    }

    public void searchByCriteria(File el, String ext, ValidArg arg) {
        String f = arg.getByName();
        String m = arg.getByMask();
        String r = arg.getByRegexp();
        String cutExt = ext.replace("*", "");
        if (f != null && ext.equals(el.getName())) {
            target = el;
        } else if (m != null && el.getName().endsWith(cutExt)) {
            target = el;
        } else if (r != null) {
            Pattern pattern = Pattern.compile(ext);
            Matcher exc = pattern.matcher(el.getName());
            if (exc.matches()) {
                target = el;
            }
        }
    }

    public static void writerOfResult(ValidArg arg, File target) {
        try (FileWriter fw = new FileWriter(arg.getOutput())) {
            fw.write("Найден следующий файл - " + target.getName() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}