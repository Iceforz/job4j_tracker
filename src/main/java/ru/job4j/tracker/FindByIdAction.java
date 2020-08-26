package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find By ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item tr = tracker.findById(id);
        if (tr != null) {
            out.println(tr.getName());
        } else {
            out.println("=== Item was not found ===");
        }
        return true;
    }
}
