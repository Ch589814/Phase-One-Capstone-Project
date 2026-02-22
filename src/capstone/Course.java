package capstone;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private  String courseCode;
    private  String title;
    private  int credit;
    private  int capacity;
    private  String department;
    private List<Student>roster=new ArrayList<>();
    // constructor
    public Course(String courseCode, String title, int credit, int capacity, String department) {
        if (courseCode == null || courseCode.trim().isEmpty())
            throw new IllegalArgumentException("Course code cannot be empty");
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Course title cannot be empty");
        if (credit <= 0) throw new IllegalArgumentException("Credit must be positive");
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        if (department == null || department.trim().isEmpty())
            throw new IllegalArgumentException("Department cannot be empty");

        this.courseCode = courseCode;
        this.title = title;
        this.credit = credit;
        this.capacity = capacity;
        this.department = department;

    }
//getters
    public int getCredit() {
        return credit;

    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<Student> getRoster() {
        return roster;
    }
    public String getTitle() {
        return title;
    }
    public int getMaxcapacity() {
        return capacity;
    }
    // method to add student
    public void addStudent(Student student) throws IllegalArgumentException {
        if (roster.size() >= capacity)
            throw new IllegalStateException("Course is full");
        if (roster.contains(student))
            throw new IllegalArgumentException("Student already enrolled");
        roster.add(student);
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", capacity=" + capacity +
                ", department='" + department + '\'' +
                ", enrolled=" + roster.size() +
                '}';
    }


    public int getCredits() {
        return credit;
    }
}
