package ru.job4j.lambda;

import java.util.Comparator;

public class Lambda {

    Comparator<String> cmpText = (left, right) -> left.compareTo(right);
    Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("compare : " + right.length() + " - " + left.length());
        return right.length() - left.length();
    };
}

