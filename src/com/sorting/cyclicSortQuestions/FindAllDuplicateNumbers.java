package com.sorting.cyclicSortQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> list = findAllDuplicateNumbers(arr);
        System.out.println(list);
    }
//    static List<Integer> findAllDuplicateNumbers(int[] arr) {
//        List<Integer> list = new ArrayList<>();
//        int i = 0;
//        while(i < arr.length) {
//            int currentIndex = arr[i] - 1;
//            if(arr[i] != arr[currentIndex]) {
//                swap(arr, i, currentIndex);
//            } else {
//                i++;
//            }
//        }
//
//        for (int j = 0; j < arr.length; j++) {
//            if(arr[j] != j+1) {
//                list.add(arr[j]);
//            }
//        }
//        return list;
//    }
//
//    static void swap(int[] arr, int index1, int index2) {
//        int temp = arr[index1];
//        arr[index1] = arr[index2];
//        arr[index2] = temp;
//    }

    static List<Integer> findAllDuplicateNumbers(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1; // Get the correct index

            if (arr[index] < 0) {
                // If already negative, it's a duplicate
                duplicates.add(Math.abs(arr[i]));
            } else {
                // Mark as visited by making it negative
                arr[index] = -arr[index];
            }
        }

        return duplicates;
    }
}
