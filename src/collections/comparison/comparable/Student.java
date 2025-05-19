package collections.comparison.comparable;

public class Student implements Comparable<Student> {
    int rollNumber;
    float marks;

    public Student(int rollNumber, float marks) {
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);
        return diff;
    }
}
