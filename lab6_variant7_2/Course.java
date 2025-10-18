package SRO.lab6_variant7_2;

import java.time.LocalDate;

public class Course {
    private String courseId;
    private String courseName;
    private String instructor;
    private int durationHours;
    private double fee;
    private String category;
    private boolean isEnrolled;
    private LocalDate startDate;

    public Course(String courseId, String courseName, String instructor,
                  int durationHours, double fee, String category, LocalDate startDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.durationHours = durationHours;
        this.fee = fee;
        this.category = category;
        this.isEnrolled = false; // по умолчанию не записан
        this.startDate = startDate;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getDurationHours() { return durationHours; }
    public double getFee() { return fee; }
    public String getCategory() { return category; }
    public boolean isEnrolled() { return isEnrolled; }
    public LocalDate getStartDate() { return startDate; }

    public void setEnrolled(boolean enrolled) {
        this.isEnrolled = enrolled;
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-15s | %-12s | %-6d | %-8.2f | %-10s | %s | %s",
                courseId, courseName, instructor, durationHours, fee, category,
                isEnrolled ? "ЗАПИСАН" : "свободен", startDate);
    }
}