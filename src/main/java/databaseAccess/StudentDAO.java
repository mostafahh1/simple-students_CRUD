package databaseAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;
import java.util.ArrayList;

public class StudentDAO {

    private static Connection conn = DBConnection.getConnection();


    // ================= INSERT =================
    public static boolean insert(Student student) {
        int id = student.getId();
        String name = student.getName();
        double gpa = student.getGpa();

        String sql = "INSERT INTO students(id, name, gpa) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, gpa);

            ps.executeUpdate();
            return true; // inserted successfully

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false; // in case of error
    }


    // ================= SELECT BY ID =================
    public static void getById(Student student) {


        String sql = "SELECT name, gpa FROM students WHERE id = ?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            int id = student.getId();
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("GPA: " + rs.getDouble("gpa"));
            } else {
                System.out.println("Not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ================= SELECT ALL =================
    public static ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, name, gpa);
                students.add(student);
            }
            return students;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return students; // in case of error, return empty list
    }

    // ================= UPDATE Gpa =================
    public static boolean updateGpa(Student student) {

        String sql = "UPDATE students SET gpa = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            double gpa = student.getGpa();
            ps.setDouble(1, gpa);
            int id = student.getId();
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                return true; // found and updated
            else
                return false; // not found

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false; // in case of error
    }

    // ================= DELETE =================
    public static boolean delete(Student student) {


        String sql = "DELETE FROM students WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int id = student.getId();
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                return true; // found and deleted
            else
                return false; // not found

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false; // in case of error
    }

}
