package com.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int digits = 15264;
        System.out.println(sumOfDigits(digits));
    }
    static int sumOfDigits(int n) {
        if(n%10 == n) {
            return n;
        }
        return sumOfDigits(n/10) + (n%10);
    }
}
