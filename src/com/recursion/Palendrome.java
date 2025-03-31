package com.recursion;

public class Palendrome {
    public static void main(String[] args) {
        System.out.println(isPalendrome(123221));
    }
    public static boolean isPalendrome(int n) {
        int digits = (int)(Math.log10(n) + 1);
        int result = helperFunction(n, digits);
        return n == result;
    }

    public static int helperFunction(int n, int digits) {
        if(n %10 == n){
            return n;
        }
        int rem = n %10;
        return rem * (int)(Math.pow(10, digits-1)) + helperFunction( n/10, digits-1);


    }
}
