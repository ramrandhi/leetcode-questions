package patterns.recursion_backTracking.subSets_subSequence.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetIterative {
    public static void main(String[] args) {
        List<List<Integer>>  list = subSetIterativeDuplicates(new int[] {1,2,2});
        for(List<Integer> dummy: list) {
            System.out.println(dummy);
        }
    }
    static List<List<Integer>> subSetIterative(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr) {
            int n = outer.size();
            for(int i = 0;i < n;i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
    // to solve problems having duplicate values
    static List<List<Integer>> subSetIterativeDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i= 0;i< arr.length;i++) {
            start = 0;
            if(i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start;j < n;j++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
