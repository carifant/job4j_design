package ru.job4j.io.findfiles;

import java.util.HashMap;
import java.util.Map;

public class ValidArg {

    private final Map<String, String> command = new HashMap<>();

    public ValidArg(String[] args) {
        for (int i = 0; i < args.length; ) {
            if (args[i].contains("=")) {
                String[] temp = args[i].split("=");
                command.put(temp[0], temp[1]);
            }
            i++;
        }
    }

    public String getDirectory() {
        return command.get("-d");
    }

    public String getByName() {
        return command.get("-f");
    }

    public String getByMask() {
        return command.get("-m");
    }

    public String getByRegexp() {
        return command.get("-r");
    }

    public String getOutput() {
        return command.get("-o");
    }
}

