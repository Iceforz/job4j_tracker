package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentVersion {
    public static Map<Integer, Student> listToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(
                Student::getScore, item -> item));
    }
}