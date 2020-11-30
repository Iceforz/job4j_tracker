package ru.job4j.tracker;

import ru.job4j.db.Store;

import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, Store store) throws SQLException;
}
