package ru.job4j.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private int score;
    private String surname;

    public Student(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("st", 99));
        students.add(new Student("st", 88));
        students.add(new Student("st", 77));
        students.add(new Student("st", 66));
        students.add(new Student("st", 55));
        students.add(new Student("st", 44));
        students.add(new Student("st", 33));
        students.add(new Student("st", 22));
        students.add(new Student("st", 11));
        students.add(new Student("st", 0));

        students.forEach(item -> System.out.println(item));

        Map<Integer, Student> map = new HashMap<>();
        map = students.stream().collect(Collectors.toMap(item -> item.getScore(), item -> item));
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
