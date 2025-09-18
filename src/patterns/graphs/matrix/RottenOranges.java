package patterns.graphs.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<column;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                }
                if(grid[i][j] == 1) freshCount++;
            }
        }
        int time = 0;
        int[][] fourDirections = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int r = p.first;
            int c = p.second;
            int t = p.currentCount;
            time = Math.max(time, t);
            for(int[] direction: fourDirections) {
                int nrow = r + direction[0];
                int ncol = c + direction[1];
                if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < column
                        && grid[nrow][ncol] == 1) {
                    grid[nrow][ncol] = 2;
                    queue.add(new Pair(nrow, ncol, t + 1));
                    count++;
                }
            }
        }
        if(count != freshCount) return -1;
        return time;
    }

    static class Pair {
        int first;
        int second;
        int currentCount;
        public Pair(int first, int second, int currentCount) {
            this.first = first;
            this.second = second;
            this.currentCount = currentCount;
        }
    }
}
