package ru.job4j.tracker;

public class Item {
    public String name;
    public int id;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void main(String[] args) {
        Item item = new Item();
    }
}