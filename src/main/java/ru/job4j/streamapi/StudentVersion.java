package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentVersion {
    public static Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, item -> item,
                (surname1, surname2) -> surname1));
    }
}