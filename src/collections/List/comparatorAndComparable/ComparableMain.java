package com.collections.comparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Somesh"));
        emp.add(new Employee(3, "sukesh"));
        emp.add(new Employee(2, "kamesh"));
        Collections.sort(emp);
        System.out.println(emp);
    }
}

class Employee implements Comparable<Employee> {
    int age;
    String name;
    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{age=" + age + ", name='" + name + "'}";
    }


    @Override
    public int compareTo(Employee other) {
        return this.age - other.age;
    }
}
