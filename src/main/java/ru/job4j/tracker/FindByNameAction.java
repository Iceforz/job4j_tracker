package ru.job4j.tracker;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find By Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> tr = tracker.findByName(name);
        for (Item item : tr) {
            out.println(item.getName());
        }
        return true;
    }
}
