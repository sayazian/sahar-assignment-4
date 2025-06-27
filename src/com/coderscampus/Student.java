package com.coderscampus;

public class Student {
    private int studentId;
    private String studentName;
    private String course;
    private int grade;

    public Student(int studentId, String studentName, String course, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
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

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

}
