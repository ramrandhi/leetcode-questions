package ruff;
import java.util.*;

public class ComparatorQuestion {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", 90),
                new Student(2, "mob", 85),
                new Student(3, "charlie", 90),
                new Student(4, "david", 80)
        );
        Collections.sort(students, new ComparatorOutSide());
        System.out.println(students);
    }
}

class Student {
    int id;
    String name;
    int marks;
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', marks=" + marks + "}";
    }
}

class ComparatorOutSide implements Comparator<Student> {

    @Override
    public int compare(Student e1, Student e2) {
        int marksCompare = Integer.compare(e2.marks, e1.marks);
        if(marksCompare == 0) {
            return e1.name.compareTo(e2.name);
        }
        return marksCompare;
    }
}
