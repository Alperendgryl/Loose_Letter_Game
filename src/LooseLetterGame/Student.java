package pkg2102_project_q1;
public class Student {

    public String studentName;
    public int studentID;
    public Student nextStudent;
    public Student previousStudent;

    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.nextStudent = null;
        this.previousStudent = null;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return studentID + " " + studentName;
    }
}
