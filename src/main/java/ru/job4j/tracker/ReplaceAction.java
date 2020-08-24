package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        item.setName(name);
        item.setId(id);
        boolean tr = tracker.replace(id, item);
        if (tr) {
            System.out.println("=== Item was replaced ===");
        } else {
            System.out.println("=== Item was not found ===");
        }
        return true;
    }
}

