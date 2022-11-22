import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            students.add(new Student());
        }
        System.out.println(students);

        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int y = 0; y < 3; y++) {
            teachers.add(new Teacher());
        }
        System.out.println(teachers);

        for (int i = 0; i < students.size() - 2; i++) {
            students.remove(students.size() - 2);
        }
        System.out.println(students);

        for (int x = 0; x < teachers.size() - 1; x++) {
            teachers.remove(teachers.size() - 1);

        }
        System.out.println(teachers);
    }
}



