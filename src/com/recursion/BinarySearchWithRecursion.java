package com.recursion;

public class BinarySearchWithRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,15,16,18,22,55,66,99,999,9902,64648,454545};
        int target = 66;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end-start) / 2;
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }
    }
}
