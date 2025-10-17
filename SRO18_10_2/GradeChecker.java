package SRO.SRO18_10_2;

import java.util.HashMap;
import java.util.Map;

public class GradeChecker {

    public static void findGrade(Map<String, Integer> grades, String student)
            throws StudentNotFoundException, LowGradeException {

        if (!grades.containsKey(student)) {
            throw new StudentNotFoundException("Студент " + student + " не найден в списке.");
        }

        int grade = grades.get(student);

        if (grade < 50) {
            throw new LowGradeException("У студента " + student + " низкая оценка: " + grade);
        }

        System.out.println("Студент " + student + " сдал успешно! Оценка: " + grade);
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Айжан", 85);
        grades.put("Дамир", 45);
        grades.put("Алия", 72);

        String[] studentsToCheck = {"Айжан", "Дамир", "Ерлан"};

        for (String student : studentsToCheck) {
            try {
                findGrade(grades, student);
            }
            catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
            catch (LowGradeException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Проверка завершена для: " + student + "\n");
            }
        }
    }
}