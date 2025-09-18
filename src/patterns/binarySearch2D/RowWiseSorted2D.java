package patterns.binarySearch2D;

import java.util.Arrays;

public class RowWiseSorted2D {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,7},
                {2,6,8},
                {3,9,10}
        };
        System.out.println(Arrays.toString(binarySearch2D(matrix, 7)));
    }

    private static int[] binarySearch2D(int[][] matrix, int target) {
        int row = 0;
        int column = matrix.length - 1;
        while(row < matrix.length && column >= 0) {
            if(matrix[row][column] == target) {
                return new int[] {row, column};
            }
            if(matrix[row][column] < target) {
                row ++ ;
            } else {
                column -- ;
            }
        }
        return new int[] {-1, -1};
    }
}
