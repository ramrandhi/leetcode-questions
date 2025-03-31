package com.RecursionWithSortingAlgorithms;

import java.util.Arrays;

public class BubbleSortWithRecursion {
    public static void main(String[] args) {
        int[] arr = {5,6,7};
        bubbleSortWithRecursion(arr, arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortWithRecursion(int[] arr, int row, int column) {
        if(row == 0) {
            return;
        }
        if(column < row) {
            if(arr[column] > arr[column + 1]) {
                int temp = arr[column];
                arr[column] = arr[column + 1];
                arr[column + 1] = temp;
            }
            bubbleSortWithRecursion(arr, row, column+1);
        } else {
            bubbleSortWithRecursion(arr, row-1, 0);
        }
    }
}
