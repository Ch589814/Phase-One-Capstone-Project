package capstone;
public class GraduateStudent extends Student {
    private static final double COST_PER_CREDIT = 100000.0;
    private static final double RESEARCH_FEE = 2500000.0;
    private int credits;

    // Constructor
    public GraduateStudent(String name, String email, String id, String dept) {
        super(name, email, id, dept);
        this.credits = 12; // Default 12 credits
    }

    // Constructor with credits parameter
    public GraduateStudent(String name, String email, String id, String dept, int credits) {
        super(name, email, id, dept);
        this.credits = credits;
    }
    // Getters and Setters
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }
        this.credits = credits;
    }

    // Implementation of calculateTuition method
    @Override
    public double calculateTuition() {
        return (COST_PER_CREDIT * credits) + RESEARCH_FEE;
    }
}