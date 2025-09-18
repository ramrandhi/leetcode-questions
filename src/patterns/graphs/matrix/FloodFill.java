package patterns.graphs.matrix;
import java.util.LinkedList;
import java.util.Queue;


public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sameColor = image[sr][sc];
        if (image[sr][sc] == color) return image;
        image[sr][sc] = color;
        int row = image.length;
        int column = image[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int r = p.first;
            int c = p.second;
            for(int[] direction: directions) {
                int nrow = r + direction[0];
                int ncol = c + direction[1];
                if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < column &&
                        image[nrow][ncol] == sameColor && image[nrow][ncol] != color) {
                    image[nrow][ncol] = color;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        return image;
    }
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}


