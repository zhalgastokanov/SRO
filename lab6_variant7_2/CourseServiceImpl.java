package SRO.lab6_variant7_2;

import kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course;
import kz.ektu.zhalgas.tokanov.lab6_variant7_2.CourseService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private Map<String, kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course> courses = new HashMap<>();

    @Override
    public boolean addCourse(kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course course) throws IllegalArgumentException {
        if (course == null) throw new IllegalArgumentException("Курс не может быть null!");
        if (course.getCourseId() == null || course.getCourseId().isEmpty())
            throw new IllegalArgumentException("ID курса не может быть пустым!");
        if (course.getFee() < 0)
            throw new IllegalArgumentException("Стоимость курса не может быть отрицательной!");
        if (courses.containsKey(course.getCourseId()))
            throw new IllegalArgumentException("Курс с таким ID уже существует!");

        courses.put(course.getCourseId(), course);
        return true;
    }

    @Override
    public boolean enrollInCourse(String courseId) throws Exception {
        if (courseId == null || courseId.isEmpty())
            throw new IllegalArgumentException("ID курса не может быть пустым!");
        if (!courses.containsKey(courseId))
            throw new Exception("Курс с ID " + courseId + " не найден!");

        kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course c = courses.get(courseId);
        if (c.isEnrolled()) {
            System.out.println("На курс " + c.getCourseName() + " уже записан пользователь.");
            return false;
        }
        c.setEnrolled(true);
        System.out.println("Успешная запись на курс: " + c.getCourseName());
        return true;
    }

    @Override
    public List<kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course> searchByCategory(String category) {
        if (category == null || category.isEmpty()) return Collections.emptyList();
        return courses.values().stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(category))
                .sorted(Comparator.comparing(kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> getDurationStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        for (kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course c : courses.values()) {
            stats.put(c.getCourseName(), c.getDurationHours());
        }
        return stats;
    }

    @Override
    public List<kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course> filterCoursesByStartDate(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) return Collections.emptyList();
        return courses.values().stream()
                .filter(c -> !c.getStartDate().isBefore(fromDate) && !c.getStartDate().isAfter(toDate))
                .sorted(Comparator.comparing(kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void printAllCourses() {
        System.out.println("ID     | Название        | Преподаватель | Длит. | Стоимость | Категория  | Статус    | Дата начала");
        System.out.println();
        courses.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        kz.ektu.zhalgas.tokanov.lab6_variant7_2.CourseServiceImpl system = new kz.ektu.zhalgas.tokanov.lab6_variant7_2.CourseServiceImpl();

        try {
            system.addCourse(new kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course("1", "Java", "Касым", 40, 50000, "IT", LocalDate.of(2025, 9, 20)));
            system.addCourse(new kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course("2", "Python", "Тима", 30, 40000, "IT", LocalDate.of(2025, 10, 1)));
            system.addCourse(new Course("3", "Маркетинг", "Аружан", 20, 35000, "Business", LocalDate.of(2025, 11, 5)));

            system.printAllCourses();

            System.out.println();
            system.enrollInCourse("2");
            System.out.println();

            System.out.println("Курсы по категории IT:");
            system.searchByCategory("IT").forEach(System.out::println);

            System.out.println("\nСтатистика по длительности:");
            System.out.println(system.getDurationStatistics());

            System.out.println("\nКурсы с 01.10.2025 по 31.12.2025:");
            system.filterCoursesByStartDate(LocalDate.of(2025, 10, 1), LocalDate.of(2025, 11, 18))
                    .forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}