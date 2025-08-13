package ruff;

import java.util.Arrays;
import java.util.HashMap;

public class SetMisMath {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] {3,2,2})));
    }

    public static int[] findErrorNums(int[] nums) {
        int duplicate = -1, missing = -1;
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{duplicate, missing};
    }
}
