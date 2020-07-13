package ru.job4j.io.findfiles;

public class ValidArg {

    private final String[] args;

    public ValidArg(String[] args) {
        this.args = args;
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

    public String include() {
        String temp = null;
        for (String x : args) {
            if (x.contains("-n=") || x.contains("-f=")) {
                temp = x.substring(3);
                break;
            } else if (x.contains("-m=")) {
                temp = x.replace("*", "");
                temp = temp.substring(3);
                break;
            } else if (x.contains("-r=")) {
                temp = "1" + x.substring(3);
                break;
            }
        }
        if (temp == null) {
            throw new IllegalArgumentException("Include folder is null. You can use different ways for search. Use -n= for searching by name, use -m= for searching by mask of files, use -f= for searching current file");
        }
        return temp;
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