package com.sorting;


import java.util.Arrays;

//  when given  numbers are from range 1 to N use Cyclic Sort.

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,6,4,7,8,9,1,2,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
