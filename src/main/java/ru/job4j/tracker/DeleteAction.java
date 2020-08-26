package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id");
        if (tracker.delete(id)) {
            out.println("=== Item was successfully deleted ===");
        } else {
            out.println("=== Item was not found ===");
        }
        return true;
    }
}
