package ru.job4j.tracker;

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
        Item[] tr = tracker.findAll();
        if (tr.length != 0) {
            for (int i = 0; i < tr.length; i++) {
                out.println("[" + tr[i].getId() + "]:" + tr[i].getName());
            }
        } else {
            out.println("Empty");
        }
        return true;
    }
}
