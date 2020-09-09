package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < Math.min(left.length(), right.length()); index++) {
            char charL = left.charAt(index);
            char charR = right.charAt(index);
            if (charL != charR) {
                return Character.compare(charL, charR);
            }
        }
        return left.length() - right.length();
    }
}
