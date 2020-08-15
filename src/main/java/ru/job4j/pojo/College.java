package ru.job4j.pojo;



public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ilya");
        student.setSurname("Goryachev");
        student.setPatronymic("Ruslanovich");
        student.setGroop("B");
        student.setDayofstart("12.05.2005");
        System.out.println(student.getSurname() + " " + student.getName() + " " + student.getPatronymic() + " stay in groop " + student.getGroop() + " from " + student.getDayofstart());
    }
}

