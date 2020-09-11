package ru.job4j.tracker;
import java.util.Collections;
import java.util.List;

public class SortItem {
    
    public static List<Item> sortUp(List<Item> items) {
        items.sort(new SortItembyName());
        return items;
}

    public static List<Item> sortDown(List<Item> items) {
        items.sort(Collections.reverseOrder());
        return items;
    }

    public static List<Item> sortbyNameDown(List<Item> items) {
        items.sort((new SortItemByNameDown()));
        return items;
    }
}