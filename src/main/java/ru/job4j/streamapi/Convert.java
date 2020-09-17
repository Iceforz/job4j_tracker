package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public List<Integer> swapToList(Integer[][] array) {
        return Arrays.stream(array).flatMap(Arrays :: stream).collect(Collectors.toList());
    }
}
