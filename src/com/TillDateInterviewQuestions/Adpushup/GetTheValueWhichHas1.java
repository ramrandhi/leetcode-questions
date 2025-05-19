package com.TillDateInterviewQuestions.Adpushup;

import java.util.HashMap;
import java.util.Map;

public class GetTheValueWhichHas1 {
    public static void main(String[] args) {
        Map<Integer, Integer> arr = new HashMap<>();
        arr.put(1,1);
        arr.put(2,1);
        arr.put(9,1);
        arr.put(5,1);
        arr.put(6,1);
        int i = 0;
        for(Integer a: arr.keySet()) {
            i++;
            if(arr.containsKey(1)) {
                System.out.println(arr.containsKey(1)+ "" + i);
            }
        }
    }
}
