package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class DataChat {

    private List<String> dialog = new ArrayList<>();
    private List<String> copy = new ArrayList<>();
    private String phrase;
    private String answer;

    public List<String> getDialog() {
        return dialog;
    }

    public void setDialog(List<String> dialog) {
        this.dialog = dialog;
    }

    public List<String> getCopy() {
        return copy;
    }

    public void setCopy(List<String> copy) {
        this.copy = copy;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

