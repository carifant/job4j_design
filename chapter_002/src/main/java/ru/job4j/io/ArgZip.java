package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 5) {
            throw new IllegalArgumentException("Some folder is null.");
        }
        return true;
    }

    public String exclude() {
        String temp = null;
        for (String x : args) {
            if (x.contains("-e=")) {
                temp = x.substring(3);
                break;
            }
        }
        if (temp == null) {
            throw new IllegalArgumentException("Exclude folder is null.");
        }
        return temp;
    }

    public String directory() {
        String dir = null;
        for (String x : args) {
            if (x.contains("-d=")) {
                dir = x.substring(3);
                break;
            }
        }
        if (dir == null) {
            throw new IllegalArgumentException("Directory folder is null.");
        }
        return dir;
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