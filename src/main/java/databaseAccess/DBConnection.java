package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn;
    private static final String URL = "jdbc:sqlite:app.db";


    private static void createDB() {

        try {
            conn = DriverManager.getConnection(URL);
            createTableStudent();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());

        }
    }


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

    public static Connection getConnection() {

        if (conn == null) {
            createDB();
        }

        return conn;
    }
}