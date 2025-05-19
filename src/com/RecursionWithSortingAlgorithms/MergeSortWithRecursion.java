package com.RecursionWithSortingAlgorithms;

import java.util.Arrays;

public class MergeSortWithRecursion {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] firstHalf = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] lastHalf = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(firstHalf, lastHalf);
    }

    public static int[] merge(int[] firsthalf, int[] secondHalf) {
        int[] mix = new int[firsthalf.length + secondHalf.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < firsthalf.length && j < secondHalf.length) {
            if(firsthalf[i] < secondHalf[j]) {
                mix[k] = firsthalf[i];
                i++;
            } else  {
                mix[k] = secondHalf[j];
                j++;
            }
            k++;
        }
        while(i < firsthalf.length) {
            mix[k] = firsthalf[i];
            i++;
            k++;
        }
        while(j < secondHalf.length) {
            mix[k] = secondHalf[j];
            j++;
            k++;
        }
        return mix;
    }
}
