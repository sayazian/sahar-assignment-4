package com.coderscampus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService {
    public static void sortStudents(Student[] students) {
        Arrays.sort(students, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getGrade(), o1.getGrade());
            }
        });
    }

    public static String[] extractCourses(Student[] students) {
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


    public static Student[] readMasterList(String sourceFileAddress) throws FileNotFoundException {
        File file = new File(sourceFileAddress);
        Student[] students = new Student[100];
        Scanner input = new Scanner(file);
        String line = input.nextLine();
        int count = 0;
        line = input.nextLine();
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
