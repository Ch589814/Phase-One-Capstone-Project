package capstone;
public class UndergraduateStudent extends Student {
    private static final double FLAT_RATE = 500000.0;

    public UndergraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    @Override
    public double calculateTuition() {
        return FLAT_RATE;
    }
}