package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore).average().getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(item -> new Tuple(item.getName(), item.getSubjects().stream()
                .mapToDouble(sub -> sub.getScore()).average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors
                        .averagingDouble(Subject::getScore))).entrySet()
                .stream().sorted((k, v) -> v.getKey().compareTo(k.getKey()))
                .map(item -> new Tuple(item.getKey(), item.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                        .stream().mapToDouble(subject -> subject.getScore()).sum()))
                .max(Comparator.comparing(Tuple::getScore)).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors
                        .summingDouble(Subject::getScore)))
                .entrySet()
                .stream().map(item -> new Tuple(item.getKey(), item.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).get();
    }
}

