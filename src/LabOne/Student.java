package LabOne;
import java.util.HashMap;
import java.util.Map;

public  abstract class Student extends Person {
    private  String studentID;
    private  String department;
    private Map<Course, Double> courseGrades = new HashMap<>();
    //constructor
    public Student(String name, String email, String studentID, String department) {
        super(name, email);
        setStudentID(studentID);
        setDepartment(department);
        this.courseGrades = new HashMap<>();
    }
    public abstract double calculateTuition();
    //method to calculate GPA
    public double calculateGpa() {
        if (courseGrades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : courseGrades.values()) total += grade;
        return total / courseGrades.size();
    }
    //getters and setters

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = department;
    }
    public void setStudentID(String studentID) {
        if (studentID == null || studentID.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        this.studentID = studentID;
    }

    public String getStudentID(){
        return studentID;
    }
    public  String getDepartment(){
        return department;
    }
    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }
    public void enrollInCourse(Course course) {
        courseGrades.putIfAbsent(course, 0.0);
    }

    public void setGrade(Course course, double grade) {
        if (!courseGrades.containsKey(course)) throw new IllegalArgumentException("Student not enrolled in course");
        courseGrades.put(course, grade);
    }

}
