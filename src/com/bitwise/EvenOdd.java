package com.bitwise;

public class EvenOdd {
    public static void main(String[] args) {
        int number = 55;
        System.out.println(isOdd(number));
    }

    public static boolean isOdd(int num) {
        return (num & 1) == 1; // & 1 checks for the last element in binary number system so if 1 & 1 returns 1.
    }
}
