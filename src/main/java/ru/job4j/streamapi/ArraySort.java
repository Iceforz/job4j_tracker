package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(-5);
        list.add(-2);
        List<Integer> bugs = list.stream().filter(
                task -> task >= 0
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
    }
}

