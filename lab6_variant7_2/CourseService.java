package SRO.lab6_variant7_2;

import kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface CourseService {
    boolean addCourse(kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course course) throws IllegalArgumentException;
    boolean enrollInCourse(String courseId) throws Exception;
    List<kz.ektu.zhalgas.tokanov.lab6_variant7_2.Course> searchByCategory(String category);
    Map<String, Integer> getDurationStatistics();
    List<Course> filterCoursesByStartDate(LocalDate fromDate, LocalDate toDate);
    void printAllCourses();
}