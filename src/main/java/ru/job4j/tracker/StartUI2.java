package ru.job4j.tracker;
import com.sun.jdi.IntegerValue;

//import java.util.Scanner;

public class StartUI2 {
    //public void init(Scanner scanner, Tracker tracker) {
        public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = input.askInt("1");
           // int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println();
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                //String name = scanner.nextLine();
                String name = input.askStr("Kate");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    if (item != null) {
                        System.out.println(" ID заявки: " + item.getId() + "Имя заявки: " + item.getName());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Введите ID завки для замены: ");
                //int id = Integer.valueOf(scanner.nextLine());
                int id =input.askInt("2");
                System.out.println("Введите новое имя заявки: ");
               // String name = scanner.nextLine();
                String name = input.askStr("Kate");
                Item item = new Item(name);
                tracker.replace(id, item);
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
               // int indexMinus = Integer.valueOf(scanner.nextLine());
                int indexMinus = input.askInt("3");
                tracker.delete(indexMinus);
            } else if (select == 4) {
                System.out.println("===  Find item by Id ===");
               // int byid = Integer.valueOf(scanner.nextLine());
                int byid = input.askInt("4");
                Item item = tracker.findById(byid);
                System.out.println(" ID заявки: " + item.getId() + " Имя заявки: " + item.getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
               // String name = scanner.nextLine();
                String name = input.askStr("Kate");
                Item[] item = tracker.findByName(name);
                for (Item items : item) {
                    System.out.println(" ID заявки: " + items.getName() + " Имя заявки: " + items.getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI2().init(input, tracker);

   // public static void main(String[] args) {
      //  Scanner scanner = new Scanner(System.in);
      //  Tracker tracker = new Tracker();
       // new StartUI2().init(scanner, tracker);
    }
}