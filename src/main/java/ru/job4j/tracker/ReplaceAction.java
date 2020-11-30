package ru.job4j.tracker;

import ru.job4j.db.Store;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Replace Item ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item();
        item.setName(name);
        boolean tr = store.replace((id), item);
        if (tr) {
            out.println("=== Item was replaced ===");
        } else {
           out.println("=== Item was not found ===");
        }
        return true;
    }
}

