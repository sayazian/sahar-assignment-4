package com.coderscampus;

public class Student {
    private final int studentId;
    private final String studentName;
    private final String course;
    private final int grade;

    public Student(int studentId, String studentName, String course, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public String getCourseWord() {
        return course.replaceAll("\\d", "").strip();
    }

    public int getGrade() {
        return grade;
    }

    public String toString() {
        return studentId + "," + studentName + "," + course + "," + grade;
    }
}
