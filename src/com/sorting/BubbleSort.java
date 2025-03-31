package com.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,45,56,0};
        int[] sortedArr = bubbleSort(arr);
        for(int a : arr) {
            System.out.print(a + ", ");
        }
    }

    public static int[] bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
