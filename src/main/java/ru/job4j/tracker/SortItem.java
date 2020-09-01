package ru.job4j.tracker;
import java.util.Collections;
import java.util.List;

public class SortItem {
    public static List<Item> sortUpId(List<Item> items) {
        Collections.sort(items);
        items = items;
        return items;
    }
    public static List<Item> sortUpName(List<Item> items) {
        items.sort(new SortItembyName());
        items = items;
        return items;
}
    public static List<Item> sortDown(List<Item> items) {
        items.sort(Collections.reverseOrder());
        items = items;
        return items;
    }
}