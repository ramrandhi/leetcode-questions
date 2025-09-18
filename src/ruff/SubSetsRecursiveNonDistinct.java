package ruff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsRecursiveNonDistinct {
    public static void main(String[] args) {
        List<List<Integer>> list = subSetsRecursiveNonDistinct(new int[] {1,3,3});
        for(List<Integer> li: list) {
            System.out.println(li);
        }
//        System.out.println(subSetsRecursiveDistinct(new int[] {1,2,3}));
    }
    static List<List<Integer>> subSetsRecursiveNonDistinct(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i = 0;i<arr.length;i++) {
            start = 0;
            if(i > 0 && arr[i] == arr[i-1]) {
                start = end;
            }
            end = outer.size();
            int n = outer.size();
            for(int j = start;j<n;j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

    static List<List<Integer>> subSetsRecursiveDistinct(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i = 0;i<arr.length;i++) {
            int n = outer.size();
            for(int j = 0;j<n;j++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
