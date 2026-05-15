package model;

/**
 * Represents a Student entity in the system.
 */
public class Student {
    private int id;
    private String name;
    private double gpa;

    /**
     * Default constructor.
     */
    public Student() {}

    /**
     * Constructs a Student with full data.
     *
     * @param id student ID
     * @param name student name
     * @param gpa student GPA
     */
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * @return student ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * @return student GPA
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param id sets student ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name sets student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param gpa sets student GPA
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
