package com.recursionWithArrays;

public class RecursionInRotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 1;
        System.out.println(rotatedBinarySearch(arr, target, 0, arr.length-1));
    }

    private static int rotatedBinarySearch(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) {
            return mid;
        }
        if(arr[start] <= arr[mid]) {
            if(arr[start] <= target &&  arr[mid] >= target) {
                return rotatedBinarySearch(arr, target, start, mid - 1);
            } else {
                return rotatedBinarySearch(arr, target, mid+1, end);
            }
        } else if(arr[mid] <= target && arr[end] >= target) {
            return rotatedBinarySearch(arr, target, mid+1, end);
        }
        return rotatedBinarySearch(arr, target, start, mid - 1);
    }
}
