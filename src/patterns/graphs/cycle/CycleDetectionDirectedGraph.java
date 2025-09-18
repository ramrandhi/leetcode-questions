package patterns.graphs.cycle;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

public class CycleDetectionDirectedGraph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<V;i++) list.add(new ArrayList<>());
        for(int[] e: edges) {
            list.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for(int i = 0;i<V;i++) {
            if(!visited[i]) {
                if(dfs(i, list, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, List<List<Integer>> list, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour: list.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, list, visited, pathVisited)) {
                    return true;
                }
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
