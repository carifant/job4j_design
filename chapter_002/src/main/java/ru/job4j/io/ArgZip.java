package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class ArgZip {

    private final String[] args;
    List<String> ext = new ArrayList<>();
    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 5) {
            throw new IllegalArgumentException("Some folder is null.");
        }
        return true;
    }

    public List<String> exclude() {
        String temp;
        for (String x : args) {
            if (x.contains("-e=")) {
                temp = x.substring(3);
                ext.add(temp);
            }
        }
        if (ext.size() == 0) {
            throw new IllegalArgumentException("Exclude folder is null.");
        }
        return ext;
    }

    public String directory() {
        String directory = null;
        for (String x : args) {
            if (x.contains("-d=")) {
                directory = x.substring(3);
                break;
            }
        }
        if (directory == null) {
            throw new IllegalArgumentException("Directory folder is null.");
        }
        return directory;
    }

    public String output() {
        String output = null;
        for (String x : args) {
            if (x.contains("-o=")) {
                output = x.substring(3);
                break;
            }
        }
        if (output == null) {
            throw new IllegalArgumentException("Output folder is null.");
        }
        return output;
    }
}