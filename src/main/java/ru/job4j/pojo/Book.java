package ru.job4j.pojo;

public class Book {
    private String name;
    private int amountofpages;

    public Book(String name, int pages) {
        this.name = name;
        this.amountofpages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return amountofpages;
    }

    public void setPages(int pages) {
        this.amountofpages = pages;
    }
}

