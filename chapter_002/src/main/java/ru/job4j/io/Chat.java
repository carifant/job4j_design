package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Chat {

    DataChat dataChat;

    public List<String> copyOfFile(String path) {
        List<String> copy = new ArrayList<>();
        try (BufferedReader reader2 = new BufferedReader(new FileReader(path))) {
            String s;
            while (reader2.ready()) {
                s = reader2.readLine();
                copy.add(s);
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return copy;
    }

    public void readOfLog(List<String> list) {
        for (String x : list) {
            System.out.println(x);
        }
    }

    public void mechanismOfChat() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean b = true;
            while (b) {
                dataChat.setPhrase(reader.readLine());
                dataChat.getDialog().add(dataChat.getPhrase());
                if (dataChat.getPhrase().contains("закончить")) {
                    break;
                } else if (dataChat.getPhrase().contains("стоп")) {
                    while (!dataChat.getPhrase().contains("продолжить")) {
                        dataChat.setPhrase(reader.readLine());
                        dataChat.getDialog().add(dataChat.getPhrase());
                        if (dataChat.getPhrase().contains("закончить")) {
                            b = false;
                            break;
                        }
                    }
                }
                if (dataChat.getPhrase().contains("закончить")) {
                    break;
                }
                dataChat.setAnswer(dataChat.getCopy().get((int) (Math.random() * dataChat.getCopy().size())));
                dataChat.getDialog().add(dataChat.getAnswer());
                System.out.println(dataChat.getAnswer());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void startChat() {
        dataChat = new DataChat();
        dataChat.setCopy(copyOfFile("text.txt"));
        mechanismOfChat();
        readOfLog(dataChat.getDialog());
    }
}

