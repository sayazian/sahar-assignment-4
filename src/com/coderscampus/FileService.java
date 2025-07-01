package com.coderscampus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public void generateFiles(String[] courses, Student[] students) throws IOException {
        int counter = 0;
        for (String course : courses) {
            if (course != null) createCourseFile(counter, courses, students);
            counter++;
        }
    }

    private void createCourseFile(int counter, String[] courses, Student[] students) throws IOException {
        File file = new File("course" + (counter + 1) + ".csv");
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                if (student != null && student.getCourseWord().equals(courses[counter]))
                    addStudentToFile(student, fileWriter);
            }
        }
    }

    private void addStudentToFile(Student student, FileWriter fileWriter) throws IOException {
        fileWriter.write(student.toString() + "\n");
    }

}
