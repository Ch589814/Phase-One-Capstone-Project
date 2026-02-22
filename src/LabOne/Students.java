package LabOne;
public class Students extends Person {
    private  String studentID;
    private  String department;
    public  Students(String name, String email,String studentID, String department){
        super(name, email);


        this.studentID = studentID;
        this.department =department;


    }

    @Override
    public double calculateTuition() {
        return 0;
    }
    public String getStudentID(){
        return studentID;
    }
    public  String getDepartment(){
        return department;
    }

    public String getEmail(){
        return super.getEmail();
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

}
