package ru.job4j.tracker;

import ru.job4j.db.SqlTracker;
import ru.job4j.db.Store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUI2 {
    private final Output out;

    public StartUI2(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + ". " + action.name());
        }

    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new FindAction(output));
        actions.add(new FindByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        try (Store store = new SqlTracker()) {
            store.init();
        new StartUI2(output).init(input, store, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


