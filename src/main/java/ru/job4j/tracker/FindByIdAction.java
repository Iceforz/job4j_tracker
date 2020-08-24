package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find By ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item tr = tracker.findById(id);
        if (tr != null) {
            System.out.println(tr.getName());
        } else {
            System.out.println("=== Item was not found ===");
        }
        return true;
    }
}
