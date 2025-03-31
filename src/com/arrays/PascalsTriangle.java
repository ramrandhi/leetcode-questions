package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args){
        int rows = 5;
        generate(rows);
        System.out.println(generate(rows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }
}
