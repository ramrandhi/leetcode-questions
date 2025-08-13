package collections.List.comparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Employees> emp = new ArrayList<>();
        emp.add(new Employees(1, "somesh"));
        emp.add(new Employees(3, "sukesh"));
        emp.add(new Employees(2, "kamesh"));
        Collections.sort(emp, new ComparatorOther());

        System.out.println(emp);
    }
}

class Employees {
    int age;
    String name;
    public Employees(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employees{age=" + age + ", name='" + name + "'}";
    }
}

class ComparatorOther implements Comparator<Employees> {
    @Override
    public int compare(Employees e1, Employees e2) {
        return e1.name.compareTo(e2.name);
    }
}
