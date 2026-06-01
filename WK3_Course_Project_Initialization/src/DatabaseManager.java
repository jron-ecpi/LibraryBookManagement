/**
 * Name: Jaymee Ronquillo
 * Date: June 1, 2026
 * Assignment: Course Project Week 4 - SQLite Database Support
 * Description: Handles SQLite connection and table creation.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:jaymee_library.db";
    private static Connection conn;

    // Connect to database
    public static Connection connect() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_URL);
                System.out.println("Database connected successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }

        return conn;
    }

    // Create table
    public static void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS books (" +
                     "book_id INTEGER PRIMARY KEY, " +
                     "title TEXT NOT NULL, " +
                     "author TEXT NOT NULL, " +
                     "genre TEXT NOT NULL, " +
                     "available INTEGER NOT NULL" +
                     ");";

        try (Statement stmt = connect().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Table creation error: " + e.getMessage());
        }
    }
}