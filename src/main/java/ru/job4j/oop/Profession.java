package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName(String name) {
        this.name = name;
        return name;
    }

    public String getSurname(String surname) {
        this.surname = surname;
        return surname;
    }

    public String getEducation(String education) {
        this.education = education;
        return education;
    }

    public String getBirthday(String birthdayday) {
        this.birthday = birthdayday;
        return birthdayday;
    }
}