package ru.job4j.tracker;
import java.util.Comparator;
public class DownCompare implements Comparator<Item> {
    @Override
        public int compare(Item item2, Item item1) {
            return item2.getName().compareTo(item1.getName());
        }
    }
