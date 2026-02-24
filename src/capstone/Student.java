package capstone;
import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {
    private String id;
    private String dept;
    private Map<Course, Double> courseGrades = new HashMap<>();

    // Constructor
    public Student(String name, String email, String id, String dept) {
        super(name, email);
        setStudentID(id);
        setDepartment(dept);
        this.courseGrades = new HashMap<>();
    }

    public abstract double calculateTuition();

    // Method to calculate GPA
    public double calculateGpa() {
        if (courseGrades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : courseGrades.values()) total += grade;
        return total / courseGrades.size();
    }

    public double getGPA() {
        return calculateGpa();
    }

    // Getters and Setters
    public void setDepartment(String dept) {
        if (dept == null || dept.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.dept = dept;
    }

    public void setStudentID(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        this.id = id;
    }

    public String getStudentID() {
        return id;
    }

    public String getDepartment() {
        return dept;
    }

    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }

    public void enrollInCourse(Course course) {
        courseGrades.putIfAbsent(course, 0.0);
    }

    public void setGrade(Course course, double grade) {
        if (!courseGrades.containsKey(course))
            throw new IllegalArgumentException("Student not enrolled in course");
        courseGrades.put(course, grade);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + " ( student id: " + id + ")");
        System.out.println("GPA: " + String.format("%.2f", calculateGpa()) + " | Department: " + dept);
    }
}