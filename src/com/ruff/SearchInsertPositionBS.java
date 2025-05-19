package com.ruff;

// https://leetcode.com/problems/search-insert-position/description/

public class SearchInsertPositionBS {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int result = 0;
        if(target < nums[0]) {
            return 0;
        } else if(target > nums[nums.length-1]) {
            return nums.length;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
                result = start;
            } else {
                end = mid - 1;
                result = end;
            }
        }
        return start;
    }
}
