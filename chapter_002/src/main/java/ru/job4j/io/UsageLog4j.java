package ru.job4j.io;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String log4jConfPath = "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}