package patterns.graphs.bipartiteGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i = 0;i<colors.length;i++) {
            if(colors[i] == -1) {
                // if(!isBfs(graph, colors, i)) {
                //     return false;
                // }
                if(!dfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBfs(int[][] graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbour: graph[node]) {
                if(colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[node];
                    queue.offer(neighbour);
                } else if(colors[neighbour] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if(colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        for(int neighbour: graph[node]) {
            if(!dfs(graph, colors, neighbour, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
