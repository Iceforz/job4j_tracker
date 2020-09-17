package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void when10AFrom70To100() {
        List<Student> students = List.of(
                new Student("st", 99),
                new Student("st", 88),
                new Student("st", 77),
                new Student("st", 66),
                new Student("st", 55),
                new Student("st", 44),
                new Student("st", 33),
                new Student("st", 22),
                new Student("st", 11),
                new Student("st", 0)
        );

        List<Student> rsl = School.collect(
                students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = students.stream().filter(student -> student.getScore() >= 70
                && student.getScore() <= 100).collect(Collectors.toList());
        assertThat(rsl, is(expected));
    }

    @Test
    public void when10BFrom50To70() {
        List<Student> students = List.of(
                new Student("st", 99),
                new Student("st", 88),
                new Student("st", 77),
                new Student("st", 66),
                new Student("st", 55),
                new Student("st", 44),
                new Student("st", 33),
                new Student("st", 22),
                new Student("st", 11),
                new Student("st", 0)
        );
        List<Student> rsl = School.collect(
                students, student -> student.getScore() >= 50 && student.getScore() <= 70);
        List<Student> expected = students.stream().filter(student -> student.getScore() >= 50
                && student.getScore() < 70).collect(Collectors.toList());
        assertThat(rsl, is(expected));
        }

    @Test
    public void when10VFrom0To50() {
        List<Student> students = List.of(
                new Student("st", 99),
                new Student("st", 88),
                new Student("st", 77),
                new Student("st", 66),
                new Student("st", 55),
                new Student("st", 44),
                new Student("st", 33),
                new Student("st", 22),
                new Student("st", 11),
                new Student("st", 0)
        );
        List<Student> rsl = School.collect(
                students, student -> student.getScore() >= 0 && student.getScore() <= 50);
        List<Student> expected = students.stream().filter(student -> student.getScore() >= 0
                && student.getScore() < 50).collect(Collectors.toList());
        assertThat(rsl, is(expected));
    }
    }
