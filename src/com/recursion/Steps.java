package com.recursion;

public class Steps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
    public static int numberOfSteps(int n) {
        return helperFunction(n, 0);
    }

    private static int helperFunction(int n, int steps) {
        if(n == 0) {
            return steps;
        }
        if(n % 2 == 0) {
            return helperFunction(n/2, steps+1);
        }
        return helperFunction(n-1, steps+1);
    }
}
