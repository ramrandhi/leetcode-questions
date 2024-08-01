package com.arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args){
        int[][] arr = {
                {1,1,1},{1,0,1},{1,1,1}
        };
        setZeroes(arr);
        print2DArray(arr);
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rowZeros = new boolean[row];
        boolean[] columnZeros = new boolean[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j]==0){
                    rowZeros[i] = true;
                    columnZeros[j] = true;

                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(rowZeros[i] || columnZeros[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
