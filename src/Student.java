import java.util.Comparator;

public class Student {
    private final int studentId;
    private String studentName;
    private String course;
    private int grade;

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
    public static class GradeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return Integer.compare(s2.getGrade(), s1.getGrade());
        }
    }
}
