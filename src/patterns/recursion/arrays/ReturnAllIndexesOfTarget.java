package patterns.recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllIndexesOfTarget {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,9,4,6,21,3,5,2,6,55};
        System.out.println(returnAllIndexsHavingTarget(arr, 3, new ArrayList<>(), 0));
        System.out.println(returnAllIndexesHavingTarget2(arr, 3, 0));
    }

    private static List<Integer> returnAllIndexsHavingTarget(int[] arr, int target, List<Integer> list, int index) {
        if(index == arr.length-1) return list;
        if(arr[index] == target) list.add(index);
        return returnAllIndexsHavingTarget(arr, target, list, index + 1);
    }

    // Another pattern where List is inside the body and not in the parameters
    private static List<Integer> returnAllIndexesHavingTarget2(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();
        if(index == arr.length-1) return list;
        if(arr[index] == target) list.add(index);
        List<Integer> subList = returnAllIndexesHavingTarget2(arr, target, index + 1);
        list.addAll(subList);
        return list;
    }
}
