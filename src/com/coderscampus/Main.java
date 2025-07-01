package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        FileService fileService = new FileService();
        String sourceFileAddress = "student-master-list.csv";
        Student[] students;
        try (Scanner input = studentService.openScanner(sourceFileAddress)) {
            students = studentService.readMasterList(input);
        } catch (FileNotFoundException e) {
            System.out.println("The file " + sourceFileAddress + " cannot be found.");
            return;
        }
        String[] courses = studentService.extractCourses(students);
        studentService.sortStudents(students);
        try {
            fileService.generateFiles(courses, students);
        } catch (IOException e) {
            System.out.println("The output files could not be successfully generated: " + e.getMessage());
        }
    }
}