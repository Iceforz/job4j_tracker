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
        students.add(new Student("Levg", 99));
        students.add(new Student("Kraig", 88));
        students.add(new Student("Willson", 77));
        students.add(new Student("Pamer", 66));
        students.add(new Student("Pamer", 66));

        Map<String, Student> map = new HashMap<>();
        map.put("Levg", new Student("Levg", 99));
        map.put("Kraig", new Student("Kraig", 88));
        map.put("Willson", new Student("Willson", 77));
        map.put("Pamer", new Student("Pamer", 66));
        assertEquals(StudentVersion.listToMap(students), map);
    }
}
