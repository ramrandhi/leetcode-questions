package com.recursion;

public class CountZeros {
    public static void main(String[] args) {

        System.out.println(countZerosInNumber(30205000));
    }
    public static int countZerosInNumber(int n) {
        int c = 0;
        return helperFunction(n, c);
    }
    public static int helperFunction(int n, int e){
        if(n == 0){
            return e;
        }
        int rem = n % 10;
        if(rem == 0) {
            e++;
            return helperFunction(n/10, e);
        }
        return helperFunction(n/10, e);
    }
}
