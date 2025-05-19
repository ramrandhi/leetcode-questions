package com.TillDateInterviewQuestions.Adpushup;

public class FindFirstIndexOfElement {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1};
        System.out.println(binarySearch(arr));
    }

    static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int result = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == 1) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        return result;
    }
}
