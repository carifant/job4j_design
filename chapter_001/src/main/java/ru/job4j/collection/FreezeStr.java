package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class FreezeStr {


    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        char[] charArr = left.toCharArray();
        char[] charArr2 = right.toCharArray();
        Arrays.sort(charArr);
        Arrays.sort(charArr2);
        return Arrays.equals(charArr, charArr2);
    }

    public static boolean eq2(String left, String right) {
        Map<Character, Integer> letters = new HashMap<>();
        char[] sArray = left.toCharArray();
        for (char c : sArray) {
            if (letters.containsKey(c)) {
                letters.put(c, letters.get(c) + 1);
            } else {
                letters.put(c, 1);
            }
        }
        char[] sArray2 = right.toCharArray();
        for (char c : sArray2) {
            if (letters.containsKey(c)) {
                letters.put(c, letters.get(c) - 1);
                if (letters.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}


