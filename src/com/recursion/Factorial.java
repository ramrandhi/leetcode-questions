package com.recursion;

public class Factorial {
    public static void main(String[] args) {
        int factorial =4;
//        System.out.println(findFactorial(factorial));
        System.out.println(sum(factorial));
    }
    public static int  findFactorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * findFactorial(n-1);
    }

    static int sum(int n) {
        if(n <= 1) {
            return n;
        }
        return n + sum(n-1);
    }
}
