package ru.job4j.db;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SqlTrackerTest {

     public Connection init() {
         try (InputStream in = SqlTracker.class.getClassLoader().
                 getResourceAsStream("app.properties")) {
             Properties config = new Properties();
             config.load(in);
             Class.forName(config.getProperty("driver-class-name"));
             return DriverManager.getConnection(
                     config.getProperty("url"),
                     config.getProperty("username"),
                     config.getProperty("password")

             );
         } catch (Exception e) {
             throw new IllegalStateException(e);
         }
     }

     @Test
     public void createItem() throws Exception {
         try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
             tracker.add(new Item(1, "name"));
             assertThat(tracker.findByName("name").size(), is(1));
         }
     }

 }