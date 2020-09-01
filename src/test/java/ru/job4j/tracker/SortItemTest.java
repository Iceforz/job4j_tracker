package ru.job4j.tracker;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;


import static org.junit.Assert.assertThat;

public class SortItemTest {

    @Test
    public void sortup() {
        SortItem srt = new SortItem();
        Item first = new Item(3, "First");
        Item second = new Item(1, "Second");
        Item third = new Item(5, "Third");
        List<Item> items = Arrays.asList(second, first, third);
        assertThat(srt.sortUpName(items), is((Arrays.asList(first, second, third))));
    }

    @Test
    public void sortdown() {
        SortItem srt = new SortItem();
        Item first = new Item(2, "First");
        Item second = new Item(5, "Second");
        Item third = new Item(6, "Third");
        List<Item> items = Arrays.asList(second, third, first);
        assertThat(srt.sortDown(items), is((Arrays.asList(third, second, first))));
    }
}