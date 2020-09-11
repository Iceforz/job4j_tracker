package ru.job4j.pojo;

 public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private String groop;
    private String dayofstart;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroop() {
        return groop;
    }

    public void setGroop(String groop) {
        this.groop = groop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayofstart() {
        return dayofstart;
    }

    public void setDayofstart(String dayofstart) {
        this.dayofstart = dayofstart;
    }
}

