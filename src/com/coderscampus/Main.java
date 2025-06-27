package com.coderscampus;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String sourceFileAddress = "student-master-list.csv";
        Student[] students;
        String[] courses;
        students = StudentService.readMasterList(sourceFileAddress);
        courses = StudentService.extractCourses(students);
        StudentService.sortStudents(students);
        FileService.generateFiles(courses, students);
    }
}