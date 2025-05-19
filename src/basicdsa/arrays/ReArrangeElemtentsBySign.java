package basicdsa.arrays;

import java.util.Arrays;

public class ReArrangeElemtentsBySign {
    public static void main(String[] args) {
        int[] nums = {-1,1};
        nums = rearrangeArray(nums);
        System.out.println(Arrays.toString(nums));
    }

        public static int[] rearrangeArray(int[] nums) {
            int[] arr = new int[nums.length];
            int positiveIndex = 0;
            int negativeIndex = 1;
            for(int i=0;i<nums.length;i++) {
                if(nums[i] > 0) {
                    arr[positiveIndex] = nums[i];
                    positiveIndex += 2;
                } else {
                    arr[negativeIndex] = nums[i];
                    negativeIndex += 2;
                }
            }
            return arr;
        }
    }
