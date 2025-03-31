package com.recursionWithArrays;

import java.util.*;

public class LinearSearchWithRecursion {
    public static void main(String[] args) {
        int[] arr = {3,2,1,19,18,9,19};
        int target = 19;
//        System.out.println(findIndex(arr, target, 0));
        List<Integer> list = findAllIndexes(arr, target, 0);
        System.out.println(list);
    }

//    public static int findIndex(int[] arr, int target, int index) {
//        if(arr[index] == target) {
//            return index;
//        }
//        if(index == arr.length-1) {
//            return -1;
//        }
//        return findIndex(arr, target, index+1);
//    }

    public static List<Integer> findAllIndexes(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();
        if(index == arr.length) {
            return list;
        }
        // this contains answer for that call only
        if(arr[index] == target) {
            list.add(index);
        }
        List<Integer> returningList = findAllIndexes(arr, target, index + 1);
        list.addAll(returningList);
        return list;
    }
}
