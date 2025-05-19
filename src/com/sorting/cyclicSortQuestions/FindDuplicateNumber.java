package com.sorting.cyclicSortQuestions;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findRepetativeNumber(arr));
    }

    static int findRepetativeNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != i + 1) {
                int currentIndex = arr[i] -1;
                if(arr[i] != arr[currentIndex]) {
                    swap(arr, i, currentIndex);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
