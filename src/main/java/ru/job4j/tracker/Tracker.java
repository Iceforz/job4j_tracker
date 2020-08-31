package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.set(size++, item);
        return item;
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

        public List <Item> findByName(String key) {
            List <Item> tr = new ArrayList<>();
            for (Item item : items) {
                if (key.equals(item.getName())) {
                    tr.add(item);
                }
            }
            return tr;
        }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        if (index != -1) {
            item.setId(id);
            this.items.set(index, item);
            rsl = true;
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
        if (indexMinus == -1) {
        }
        if (indexMinus > -1) {
           // System.arraycopy(source, startPos, dist, distPos, length);//
            System.arraycopy(items, indexMinus + 1, items, indexMinus, size - indexMinus);
            size--;
            result = true;
        }
        return result;
    }
}




