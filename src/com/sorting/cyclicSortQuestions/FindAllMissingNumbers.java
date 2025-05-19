package com.sorting.cyclicSortQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {7,3,2,4,8,2,3,1};
        List<Integer> list = findAllMissingNumbers(nums);
        System.out.println(list);
    }

//    public static List<Integer> findAllMissingNumbers(int[] arr) {
//        List<Integer> list = new ArrayList<>();
//        int i = 0;
//
//        int max = Integer.MIN_VALUE;
//
//        for (int num : arr) {
//            max = Math.max(max, num);
//        }
//
//        while (i < arr.length) {
//            int correctIndex = arr[i] - 1;
//            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
//                swap(arr, i, correctIndex);
//            } else {
//                i++;
//            }
//        }
//
//        boolean[] present = new boolean[max + 1];
//        for (int num : arr) {
//            if (num > 0 && num <= max) {
//                present[num] = true;
//            }
//        }
//
//        for (int j = 1; j <= max; j++) {
//            if (!present[j]) {
//                list.add(j);
//            }
//        }
//
//        return list;
//    }

    public static List<Integer> findAllMissingNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int currentIndex = arr[i] - 1;
            if(arr[i] != arr[currentIndex]) {
                swap(arr, i, currentIndex);
            } else {
                i++;
            }
        }

        for(int j=0;j<arr.length;j++) {
            if(arr[j] != j+1) {
                list.add(j+1);
            }
        }
        return list;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
