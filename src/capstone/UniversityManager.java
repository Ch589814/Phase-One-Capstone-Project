package capstone;
import java.util.*;

public class UniversityManager {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course)
            throws CourseFullException, StudentAlreadyEnrolledException {

        if (course.getRoster().contains(student)) {
            throw new StudentAlreadyEnrolledException("Student already enrolled.");
        }

        if (course.getRoster().size() >= course.getMaxcapacity()) {
            throw new CourseFullException("Course is full.");
        }

        course.getRoster().add(student);
        student.getCourseGrades().put(course, 0.0);
    }

    public List<Student> getStudents() {
        return students;
    }
    public double calculateAverageGpa(String department) {
        return students.stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase(department))
                .mapToDouble(Student::calculateGpa)
                .average()
                .orElse(0.0);
    }
    public Student getTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::calculateGpa))
                .orElse(null);
    }

}