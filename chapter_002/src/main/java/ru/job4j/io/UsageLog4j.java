package ru.job4j.io;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String log4jConfPath = "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        String name = "Unnown name";
        int age = 25;
        byte countOfFingers = 20;
        short countOfHairs = 25000;
        long countOfMolecul = 40000000;
        float numberOfSomething = 12.2f;
        double somethingElse = 22.5;
        char sigh = 'a';
        boolean secret = true;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("User info countOfFingers : {}, countOfHairs : {}", countOfFingers, countOfHairs);
        LOG.debug("User info numberOfSomething : {}, countOfMolecul : {}", numberOfSomething, countOfMolecul);
        LOG.debug("User info somethingElse : {}, sigh : {}, secret {}", somethingElse, sigh, secret);


    }
}