package SRO.SRO18_10_1;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int age) {
        try {
            Student s = new Student(name, age);
            students.add(s);
            System.out.println("Студент добавлен: " + s);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStudents() {
        System.out.println("\nСписок студентов:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        School school = new School();

        school.addStudent("Касым", 19);
        school.addStudent("Тима", 20);

        school.addStudent("Аружан", 16);
        school.addStudent("Еркежан", 17);

        school.addStudent("Назерке", 18);

        school.showStudents();
    }
}