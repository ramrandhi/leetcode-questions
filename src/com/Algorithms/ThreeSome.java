package com.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSome {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);

        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    arr.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while(start < end && nums[end] == nums[end - 1] ) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return arr;
    }
}
