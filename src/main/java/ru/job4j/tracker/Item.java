package ru.job4j.tracker;
//
public class Item implements Comparable<Item> {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Item() {
        return;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("id: %s, name: %s", id, name);
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(id, item.id);
    }
}
