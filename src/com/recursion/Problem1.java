package com.recursion;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(message(1));
    }
    public static int message(int n) {
        if(n == 5) {
//            System.out.println(n);
            return n;
        }
        System.out.println(n);
        return (message(n+1));
    }
}
