package com.recursion;

import java.awt.*;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber2(1824));
//        reverseNumber1(1824);
//        System.out.println(sum);
    }
    static int sum = 0;
    private static void reverseNumber1(int n) {
        if(n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseNumber1(n/10);
    }

    private static int reverseNumber2(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        return helperFunction(n, digits);
    }

    private static int helperFunction(int n, int digits) {
        if(n%10 == n) {
            return n;
        }
        int rem = n %10;
        return rem * (int)Math.pow(10, digits - 1) + helperFunction(n/10, digits - 1);
    }
}
