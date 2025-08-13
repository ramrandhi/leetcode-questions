package ruff;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        System.out.println(minSubArrayLen(4, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, windowSum = 0, end = 0, minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            windowSum += nums[i];
            if(windowSum == target) {
                minLength = Math.min(minLength, end-start+1);
                end++;
            } else if(windowSum < target) {
                end++;
            } else {
                windowSum = windowSum - nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
