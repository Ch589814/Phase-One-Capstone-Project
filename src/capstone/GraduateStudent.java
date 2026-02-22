package capstone;
public class GraduateStudent extends Student {
    private static final double COST_PER_CREDIT = 100000.0;
    private static final double RESEARCH_FEE = 2500000.0;
//constructor
    public GraduateStudent(String name, String email, String id, String dept) {
        super(name, email, id, dept);
    }
//implementation of calculate tuition method
    @Override
    public double calculateTuition() {
        int totalCredits = getCourseGrades().keySet()
                .stream()
                .mapToInt(Course::getCredits)
                .sum();
        return totalCredits * COST_PER_CREDIT + RESEARCH_FEE;
    }
}