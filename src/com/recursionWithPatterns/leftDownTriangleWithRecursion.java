package com.recursionWithPatterns;

public class leftDownTriangleWithRecursion {
    public static void main(String[] args) {
//        leftDownTriangle(4, 0);
        leftUpTriangle(4,0);
    }
    public static void leftDownTriangle(int row, int column) {
        if(row == 0) {
            return;
        }
        if(column < row) {
            System.out.print("*");
            leftDownTriangle(row, column+1);
        } else {
            System.out.println();
            leftDownTriangle(row-1, 0);
        }
    }

    public static void leftUpTriangle(int row, int column) {
        if(row == 0) {
            return;
        }
        if(column < row) {
            leftUpTriangle(row, column+1);
            System.out.print("*");
        } else {
            leftUpTriangle(row-1, 0);
            System.out.println();
        }
    }
}
