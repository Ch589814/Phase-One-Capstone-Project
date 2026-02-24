package capstone;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String title;
    private int credit;
    private int capacity;
    private String dept;
    private List<Student> roster = new ArrayList<>();

    // Constructor
    public Course(String courseCode, String title, int credit, int capacity, String dept) {
        if (courseCode == null || courseCode.trim().isEmpty())
            throw new IllegalArgumentException("Course code cannot be empty");
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Course title cannot be empty");
        if (credit <= 0) throw new IllegalArgumentException("Credit must be positive");
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        if (dept == null || dept.trim().isEmpty())
            throw new IllegalArgumentException("Department cannot be empty");

        this.courseCode = courseCode;
        this.title = title;
        this.credit = credit;
        this.capacity = capacity;
        this.dept = dept;
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCredit() { return credit; }
    public int getCredits() { return credit; }
    public int getMaxcapacity() { return capacity; }
    public String getDepartment() { return dept; }
    public List<Student> getRoster() { return roster; }

    //  method to check if course is full
    public boolean isFull() {
        return roster.size() >= capacity;
    }

    // Method to add student
    public void addStudent(Student student) {
        if (isFull())
            throw new IllegalStateException("Course is full");
        if (roster.contains(student))
            throw new IllegalArgumentException("Student already enrolled");
        roster.add(student);
    }

    // Method to remove student
    public void removeStudent(Student student) {
        if (!roster.contains(student))
            throw new IllegalArgumentException("Student is not enrolled in this course");
        roster.remove(student);
    }

    // Display course info
    public void displayCourseInfo() {
        System.out.println("Course: " + title + " (" + courseCode + ")");
        System.out.println("Credits: " + credit + " | Capacity: " + roster.size() + "/" + capacity);
        System.out.println("Department: " + dept);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", capacity=" + capacity +
                ", department='" + dept+ '\'' +
                ", enrolled=" + roster.size() +
                '}';
    }
}