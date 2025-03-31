package com.patterns;

public class AllPatterns {
    public static void main(String[] args) {
//        squareStars(5);
//        leftTrianglestars(5);
//        invertedLeftTriangle(5);
//        leftTriangleWithNumbers(5);
        leftFullTriangle(5);
    }
    private static void squareStars(int n) {
//        *****
//        *****
//        *****
//        *****
//        *****
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
//        Alternative way to optimize code
//        String row = "*".repeat(n);
//        for (int i = 0; i < n; i++) {
//            System.out.println(row);
//        }
    }

    private static void leftTrianglestars(int n) {
//        *
//        **
//        ***
//        ****
//        *****
        for(int i=0;i<n;i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void invertedLeftTriangle(int n) {
//        *****
//        ****
//        ***
//        **
//        *

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void leftTriangleWithNumbers(int n) {
//        1
//        1 2
//        1 2 3
//        1 2 3 4
//        1 2 3 4 5
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void leftFullTriangle(int n) {
//        *
//        **
//        ***
//        ****
//        *****
//        ****
//        ***
//        **
//        *
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = n-i; j > 0; j--) {
                if(j == n) {
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
