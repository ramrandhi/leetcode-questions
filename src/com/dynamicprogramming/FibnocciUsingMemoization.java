package com.dynamicprogramming;

import java.util.HashMap;

public class FibnocciUsingMemoization {
    public static void main(String [] args){
        System.out.println(fibonaccieUsingMemoization(6));
    }

    public static int fibonaccieUsingMemoization(int num){
        return fibonaccieUsingMemoization(num, new HashMap<>());
    }

    public static int fibonaccieUsingMemoization(int n, HashMap<Integer, Integer> memo){
        if(n==0 || n==1){
            return n;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = fibonaccieUsingMemoization(n-1, memo) + fibonaccieUsingMemoization(n-2, memo);
        memo.put(n, result);
        return result;
    }
}
