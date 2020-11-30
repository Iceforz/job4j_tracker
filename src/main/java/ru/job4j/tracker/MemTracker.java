package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.set(size++, item);
        return item;
    }

    private String generateId() {
        return String.valueOf(new Random().nextLong() + System.currentTimeMillis());
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

        public List<Item> findByName(String key) {
            List<Item> tr = new ArrayList<>();
            for (Item item : items) {
                if (key.equals(item.getName())) {
                    tr.add(item);
                }
            }
            return tr;
        }

    public boolean replace(int id, Item item) {
        boolean rsl = true;
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        if (index != -1) {
            item.setId(id);
            this.items.set(index, item);
            return true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean result = false;
        int indexMinus = indexOf(id);
        if (indexMinus != -1 && indexMinus < items.size()) {
            items.remove(items.get(indexMinus));
            result = true;
        }
        return result;
    }
}




