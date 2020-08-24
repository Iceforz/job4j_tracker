package ru.job4j.tracker;

public class FindAction implements UserAction {
    @Override
    public String name() {
        return "=== All Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] tr = tracker.findAll();
        if (tr.length != 0) {
            for (int i = 0; i < tr.length; i++) {
                System.out.println("[" + tr[i].getId() + "]:" + tr[i].getName());
            }
        } else {
            System.out.println("Empty");
        }
        return true;
    }
}
