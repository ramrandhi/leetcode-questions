package com.patterns;

public class Ruff {
    public static void main(String[] args) {
        int n = 5;
        String row = "*".repeat(n);
        for (int i = 0; i < n; i++) {
            System.out.println(row);
        }
    }
}
