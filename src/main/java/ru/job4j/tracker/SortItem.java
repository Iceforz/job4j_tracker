package ru.job4j.tracker;
import java.util.Collections;
import java.util.List;

public class SortItem {
    
    public static List<Item> sortUp(List<Item> items) {
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