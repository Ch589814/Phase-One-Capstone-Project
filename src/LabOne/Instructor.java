package LabOne;
public class Instructor extends  Person{
    private String department;
    public Instructor(String name, String email,String department) {
        super(name, email);
        this.department=department;
        setDepartment(department);
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = department;
    }
    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
