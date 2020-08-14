package ru.job4j.tracker;

public class Item {
    public String name;
    public String id;

    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void main(String[] args) {
        Item item = new Item();
    }
}