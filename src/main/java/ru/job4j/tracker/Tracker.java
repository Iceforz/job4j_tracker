package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemswithoutnull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item id = items[index];
                itemswithoutnull[size] = id;
                size++;
            }
    return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
       // Item rsl = null;
        int size = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item id = items[index];
            if (id.equals(key)) {
                rsl[size] = id;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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



