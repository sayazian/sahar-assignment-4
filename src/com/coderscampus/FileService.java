package com.coderscampus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public static void generateFiles(String[] courses, Student[] students) throws IOException {
        for (String course : courses) {
            if (course != null) createCourseFile(course, students);
        }
    }

    private static void createCourseFile(String course, Student[] students) throws IOException {
        File file = new File(course.strip() + ".csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Student ID,Student Name,Course,Grade\n");
        for (Student student : students) {
            if (student != null && student.getCourseWord().equals(course)) addStudentToFile(student, fileWriter);
        }
        fileWriter.close();
    }


    private static void addStudentToFile(Student student, FileWriter fileWriter) throws IOException {
        fileWriter.write(student.toString() + "\n");
    }

}
