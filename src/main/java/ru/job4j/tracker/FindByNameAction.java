package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find By Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] tr = tracker.findByName(name);
        for (Item req : tr) {
            System.out.println(req.getName());
        }
        return true;
    }
}
