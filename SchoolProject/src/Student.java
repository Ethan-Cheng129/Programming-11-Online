public class Student {
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int[] getStudentid() {
        return studentid;
    }

    public void setStudentid(int[] studentid) {
        this.studentid = studentid;
    }

    private String lastname;
    private int grade;
    private int[] studentid;
    static int student;

    private int studentnum = 0;


    Student() { // This is the builder that creates the "Student" object.
        firstname = "";
        lastname = "";
        grade = (int) (Math.random() * 12);//This randomizes the student's grade.
        studentnum = (int) (Math.random() * 1000000);// This creates the student's student number.
            /* This for loop is used to put random numbers inside an array that
            holds seven elements. */
    }


    Student(String firstname, String lastname, int grade, int[] studentid) {// this sets the name, grade and student number of the student.
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
        this.studentid = new int[7];
        for (int y = 0; y < studentid.length; y++) {
            studentid[y] = studentnum;
        }

    }

    @Override
    public String toString() {
        return "Name: " + this.firstname + " " + this.lastname + "Grade: " + this.grade + " Studentid: " + this.studentnum; // This is the format of the student array.
    }
}
