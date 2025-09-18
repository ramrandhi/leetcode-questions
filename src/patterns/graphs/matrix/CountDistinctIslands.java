package patterns.graphs.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

public class CountDistinctIslands {
    private int countDistinctIslands(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        Set<List<String>> set = new HashSet<>();
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<column;j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, visited, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] grid, List<String> list, int row0, int col0) {
        visited[row][col] = true;
        list.add(toString(row - row0, col - col0));
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] direction : directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, visited, grid, list, row0, col0);
            }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
