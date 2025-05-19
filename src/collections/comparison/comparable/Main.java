package collections.comparison.comparable;

public class Main{
    public static void main(String[] args) {
        Student ram = new Student(12, 31.52f);
        Student shyam = new Student(14, 29.22f);
        if (ram.compareTo(shyam) < 0) {
            System.out.println("Ram has fewer marks than Shyam");
        } else if (ram.compareTo(shyam) > 0) {
            System.out.println("Ram has more marks than Shyam");
        } else {
            System.out.println("Ram and Shyam have equal marks");
        }
    }
}
