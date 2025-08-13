package algorithms.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSome {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(arr);
        for(List li: list) {
            System.out.println(li);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int mid = 1;
        int end = mid + 1;
        for(int i=0;i<nums.length;i++) {
            List<Integer> subList = new ArrayList<>();
            while(end < nums.length) {
                if(nums[start] + nums[mid] + nums[end] == 0) {
                    subList.addAll(Arrays.asList(nums[start], nums[mid], nums[end]));
                } else if(nums.length == 3 && nums[start] + nums[mid] + nums[end] != 0) {
                    return new ArrayList<>();
                }
                end++;
            }
            if(!subList.isEmpty()) {
                list.add(subList);
            }
            mid = mid + 1;
            end = mid + 1;
        }
        return list;
    }
}
