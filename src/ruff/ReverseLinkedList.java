package ruff;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        int k = 4;
        int iterationsToMake = list.size() / k;
        List<Integer> reversedList = retriveReversedList(list, k, iterationsToMake);
        for (int rev : reversedList) {
            System.out.print(rev + ", ");
        }
    }

    public static List<Integer> retriveReversedList(List<Integer> list, int k, int iterationsToMake) {
        int startIndex = 0;
        int endIndex = k;
        for (int i = startIndex; i < iterationsToMake; i++) {
            List<Integer> subList = list.subList(startIndex, endIndex);
//            Collections.reverse(subList);
            reverseList(subList);
            startIndex += k;
            endIndex = Math.min(endIndex + k, list.size());
        }
        return list;
    }

    public static void reverseList(List<Integer> list) {
        int start = 0;
        int end = list.size()-1;
        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;

        }
    }
}
