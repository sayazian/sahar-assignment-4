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

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
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

    public static class GradeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            if (s1.getGrade() > s2.getGrade()) return 1;
            if (s1.getGrade() < s2.getGrade()) return -1;
            else return 0;
        }

    }
}
