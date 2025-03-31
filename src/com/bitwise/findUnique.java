package com.bitwise;

public class findUnique {
    public static void main(String[] args) {
        int[] arr = {1,1,9,9,4,3,3};
        System.out.println(ans(arr));
    }

    public static int ans(int[] arr) {
        int unique = 0;
        for(int n: arr) {
            unique = unique ^ n;
        }
        return unique;
    }
}
