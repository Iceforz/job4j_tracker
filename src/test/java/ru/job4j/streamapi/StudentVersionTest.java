package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class StudentVersionTest {

    @Test
    public void whenConvert() {

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

        Map<Integer, Student> map = new HashMap<>();
        map.put(99, new Student("st", 99));
        map.put(88, new Student("st", 88));
        map.put(77, new Student("st", 77));
        map.put(66, new Student("st", 66));
        map.put(55, new Student("st", 55));
        map.put(44, new Student("st", 44));
        map.put(33, new Student("st", 33));
        map.put(22, new Student("st", 22));
        map.put(11, new Student("st", 11));
        map.put(0, new Student("st", 0));

        assertEquals(StudentVersion.listToMap(students), map);
    }
}
