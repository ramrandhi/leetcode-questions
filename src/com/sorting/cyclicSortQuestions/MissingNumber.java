package com.sorting.cyclicSortQuestions;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int missingNumber = missingNumber(nums);
        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correctedIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctedIndex]) {
                swap(nums, i, correctedIndex);
            } else {
                i++;
            }
        }
        for(int j=0;j<nums.length;j++) {
           if(nums[j] != j) {
                 return j;
            }
        }
        return nums.length;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
