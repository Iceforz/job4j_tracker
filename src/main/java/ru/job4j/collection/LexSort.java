package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] numOne = left.split("\\.");
        String[] numTwo = right.split("\\.");
        return Integer.parseInt(numOne[0]) - Integer.parseInt(numTwo[0]);
    }
}

