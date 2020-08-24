package ru.job4j.tracker;
import com.sun.jdi.IntegerValue;
//import java.util.Scanner;

public class StartUI2 {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new FindAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ReplaceAction(),

        };
        new StartUI().init(input, tracker, actions);
    }
}
