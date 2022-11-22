import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> subjects = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getRivalschool() {
        return rivalschool;
    }

    public void setRivalschool(String rivalschool) {
        this.rivalschool = rivalschool;
    }

    private String mascot;
    private String rivalschool;

    School() {// this builder creates the School object. It holds the Teacher array list, student array list and the subject array list.
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> subjects = new ArrayList<>();
        name = "";
        mascot = "";
        rivalschool = "";

    }

    School(String name, String mascot, String rivalschool) {
        this.name = name;
        this.mascot = mascot;
        this.rivalschool = rivalschool;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove((student));
    }

    public void showTeacher(Teacher teacher) {
        for (int y = 0; y < teachers.size(); y++) {
            System.out.println(teachers.get(y).getFirstname() + teachers.get(y).getLastname() + teachers.get(y).getSubject());/* This is what gets printed out when the teacher
            array list is printed out. */
        }
    }

    public void showStudent(Student student) {
        for (int y = 0; y < students.size(); y++) {
            System.out.println(students.get(y).getFirstname() + students.get(y).getLastname() + students.get(y).getGrade() + students.get(y).getStudentid());/* This is what gets printed out when the student
            array list is printed out. */
        }
    }


}

