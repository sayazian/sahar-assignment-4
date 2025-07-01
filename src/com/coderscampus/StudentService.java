package com.coderscampus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService {
    public void sortStudents(Student[] students) {
        Arrays.sort(students, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getGrade(), o1.getGrade());
            }
        });
    }

    public String[] extractCourses(Student[] students) {
        String[] courses = new String[100];
        String course;
        for (Student student : students) {
            if (student != null) {
                course = student.getCourseWord();
                if (!courseExists(course, courses)) addCourse(course, courses);
            }
        }
        return courses;
    }

    private static void addCourse(String course, String[] courses) {
        int realCourseCount = 0;
        for (String courseInArray : courses) if ((courseInArray != null)) realCourseCount++;
        courses[realCourseCount] = course;
    }

    private static boolean courseExists(String course, String[] courses) {
        for (String courseInArray : courses) if ((courseInArray != null) && courseInArray.equals(course)) return true;
        return false;
    }

    public Scanner openScanner(String sourceFileAddress) throws FileNotFoundException {
        File file = new File(sourceFileAddress);
        return new Scanner(file);
    }

    public Student[] readMasterList(Scanner input) {
        Student[] students = new Student[100];
        int count = 0;
        input.nextLine();
        String line = input.nextLine();
        while (line != null) {
            String[] elements = line.split(",");
            students[count] = new Student(Integer.parseInt(elements[0]), elements[1], elements[2], Integer.parseInt(elements[3]));
            count++;
            if (input.hasNext()) line = input.nextLine();
            else break;
        }
        return students;
    }
}
