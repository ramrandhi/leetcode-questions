package com.dynamicprogramming;

import java.util.HashMap;

public class SumPossible {
    public static void main(String[] args) {
        int amount = 15;
        int[] numbers = { 4, 6, 10 };
        System.out.println(sumPossible(amount, numbers));
    }

    private static boolean sumPossible(int amount, int[] numbers) {

        return sumPossible(amount, numbers, new HashMap<>());
    }

    private static boolean sumPossible(int amount, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int num : numbers) {
            int subAmount = amount - num;
            if (sumPossible(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }

        }
        memo.put(amount, false);
        return false;
    }
}
