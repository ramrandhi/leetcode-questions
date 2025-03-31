package com.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = getSmallestIndex(arr, i, arr.length);
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    private static int getSmallestIndex(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i < end; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        if(index != 0) {
            return index;
        }
        return start;
    }
}
