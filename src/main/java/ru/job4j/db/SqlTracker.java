package ru.job4j.db;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = cn.prepareStatement(
                "insert into items(name) values (?);",
                Statement.RETURN_GENERATED_KEYS
        )) {
            st.setString(1, item.getName());
            st.executeUpdate();
            ResultSet result = st.getGeneratedKeys();
            if (result.next()) {
                item.setId(result.getInt(1));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean success = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "update items set name = ? where id = ?;"
        )) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            int affectedRows = statement.executeUpdate();
            success = affectedRows > 0;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        try (PreparedStatement st = cn.prepareStatement(
                "delete from items where id = ?;"
        )) {
            st.setInt(1, id);
            int affectedRows = st.executeUpdate();
            success = affectedRows > 0;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items;"
        )) {
            ResultSet queryResult = st.executeQuery();
            while (queryResult.next()) {
                Item item = new Item();
                item.setId(queryResult.getInt("id"));
                item.setName(queryResult.getString("name"));
                result.add(item);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items where name = ?;"
        )) {
            st.setString(1, key);
            ResultSet queryResult = st.executeQuery();
            while (queryResult.next()) {
                Item item = new Item();
                item.setId(queryResult.getInt("id"));
                item.setName(queryResult.getString("name"));
                result.add(item);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = new Item();
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items where id = ?;"
        )) {
            st.setInt(1, id);
            ResultSet queryResult = st.executeQuery();
            if (queryResult.next()) {
                result.setId(queryResult.getInt("id"));
                result.setName(queryResult.getString("name"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}