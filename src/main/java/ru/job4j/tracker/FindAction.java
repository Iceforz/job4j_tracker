package ru.job4j.tracker;
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
    public boolean execute(Input input, Tracker tracker) {
        List<Item> tr = tracker.findAll();
        for (Item item : tr) {
                out.println("[" + item.getId() + "]:" + item.getName());
        }
        return true;
    }
}
