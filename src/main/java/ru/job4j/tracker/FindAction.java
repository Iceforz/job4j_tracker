package ru.job4j.tracker;
import ru.job4j.db.Store;

import java.util.List;
public class FindAction implements UserAction {
    private final Output out;

    public FindAction(Output out) {
    this.out = out;
}

    @Override
    public String name() {
        return "=== All Items ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        List<Item> tr = store.findAll();
        for (Item item : tr) {
                out.println("[" + item.getId() + "]:" + item.getName());
        }
        return true;
    }
}
