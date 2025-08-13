package ruff;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10},6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] {-1,-1};
        int[] arr = new int[2];
        arr[0] = search(nums, target, true);
        if(arr[0] != -1) {
            arr[1] = search(nums, target, false);
        } else {
            arr[1] = -1;
        }
        return arr;
    }
    private static int search(int[] nums, int target, boolean isPresentAtLeft) {
        int start = 0, end = nums.length-1, isIndexFound = -1;;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target > nums[mid]) {
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                isIndexFound = mid;
                if(isPresentAtLeft) {
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return isIndexFound;
    }
}
