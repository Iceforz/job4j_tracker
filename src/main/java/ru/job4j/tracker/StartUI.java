package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        System.out.println(tracker.findById(1));
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        item.setName(name);
        tracker.add(item);
    }

    public static void findAll(Input input, Tracker tracker) {
       Item[] tr = tracker.findAll();
        if (tr.length != 0) {
            for (int i = 0; i < tr.length; i++) {
                System.out.println("[" + tr[i].getId() + "]:" + tr[i].getName());
            }
        } else {
            System.out.println("Empty");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
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
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        boolean tr = tracker.delete(id);
        if (tr) {
            System.out.println("=== Item was successfully deleted ===");
        } else {
            System.out.println("=== Item was not found ===");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item tr = tracker.findById(id);
        if (tr != null) {
            System.out.println(tr.getName());
        } else {
            System.out.println("=== Item was not found ===");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] trn = tracker.findByName(name);
        for (Item req : trn) {
            System.out.println(req.getName());
        }
    }
}

