package patterns.graphs.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class Matrix_01 {
    static class Triple {
        int crow, ccol, step;
        public Triple(int crow, int ccol, int step) {
            this.crow = crow;
            this.ccol = ccol;
            this.step = step;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] updatedMatrix = new int[row][column];
        boolean[][] visited = new boolean[row][column];
        Queue<Triple> queue = new LinkedList<>();
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<column;j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Triple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Triple t = queue.poll();
            int r = t.crow;
            int c = t.ccol;
            int step = t.step;
            updatedMatrix[r][c] = step;
            int[][] directions = {{0,-1}, {0, 1}, {-1,0}, {1,0}};

            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Triple(nr, nc, step + 1));
                }
            }
        }
        return updatedMatrix;
    }

    public static void main(String[] args) {

    }
}
