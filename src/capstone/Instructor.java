package capstone;

public class Instructor extends Person {
    private String dept;

    public Instructor(String name, String email, String dept) {
        super(name, email);
        setDepartment(dept);  //
    }

    public String getDepartment() {
        return dept;
    }

    public void setDepartment(String dept) {
        if (dept == null || dept.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.dept = dept;
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + dept);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", department='" + dept + '\'' +
                '}';
    }
}