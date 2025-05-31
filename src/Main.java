import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String sourceFileAddress = "/Users/sahar/Work/CC/sahar-assignment-4/src/student-master-list_2.csv";
        List<Student> students;
        students = readMasterList(sourceFileAddress);
        System.out.println(students.toString());
        students.sort(new Student.GradeComparator());
        System.out.println(students.toString());
    }

    private static List<Student> readMasterList(String sourceFileAddress) throws FileNotFoundException {
        File file = new File(sourceFileAddress);
        List<Student> students = new ArrayList<>();
        Scanner input = new Scanner(file);
        String line = input.nextLine();
        line = input.nextLine();
        while (line != null) {
            String[] elements = line.split(",");
            students.add(new Student(Integer.parseInt(elements[0]),elements[1],elements[2], Integer.parseInt(elements[3])));
            if(input.hasNext()) line = input.nextLine();
            else break;
        }
        return students;
    }
}