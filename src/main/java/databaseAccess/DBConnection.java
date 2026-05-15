package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Handles database connection and initialization.
 * Creates SQLite database and tables automatically.
 */
public class DBConnection {

    private static Connection conn;
    private static final String URL = "jdbc:sqlite:app.db";

    /**
     * Creates database connection and initializes tables.
     */
    private static void createDB() {

        try {
            conn = DriverManager.getConnection(URL);
            createTableStudent();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());

        }
    }

    /**
     * Creates students table if it does not exist.
     */
    private static void createTableStudent() {

        String sql = """

                CREATE TABLE IF NOT EXISTS students (

                    id INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    gpa REAL

                );

                """;

        try {
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());

        }
    }

    /**
     * Provides a singleton database connection instance.
     *
     * If the connection is not already created, it initializes
     * the SQLite database and creates required tables.
     *
     * @return active database connection
     */
    public static Connection getConnection() {

        if (conn == null) {
            createDB();
        }

        return conn;
    }
}