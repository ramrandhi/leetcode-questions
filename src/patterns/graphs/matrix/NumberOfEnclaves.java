package patterns.graphs.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-enclaves/description/

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < column; i++) {
            if (!visited[0][i] && grid[0][i] == 1) {
                queue.add(new Pair(0,i));
                visited[0][i] = true;
            }
            if (!visited[row - 1][i] && grid[row - 1][i] == 1) {
                queue.add(new Pair(row - 1, i));
                visited[row - 1][i] = true;
            }
        }
        for (int j = 0; j < row; j++) {
            if (!visited[j][0] && grid[j][0] == 1) {
                queue.add(new Pair(j,0));
                visited[j][0] = true;
            }
            if (!visited[j][column - 1] && grid[j][column - 1] == 1) {
                queue.add(new Pair(j,column - 1));
                visited[j][column - 1] = true;
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int cRow = p.r;
            int cCol = p.c;
            for (int[] direction : directions) {
                int nRow = cRow + direction[0];
                int nCol = cCol + direction[1];
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < column && !visited[nRow][nCol]
                        && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }

        }
        int count = 0;
        for(int i = 0;i<row;i++) {
            for(int j =0;j<column;j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(arr));
    }
}
