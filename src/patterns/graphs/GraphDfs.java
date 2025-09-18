package patterns.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphDfs {
    public static List<Integer> dfsOfGraph(int start, List<List<Integer>> adj) {
        int v = adj.size();  // number of vertices
        boolean[] vis = new boolean[v]; // visited array
        List<Integer> ls = new ArrayList<>();
        dfs(start, vis, adj, ls);
        return ls;
    }

    private static void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        int v = 5; // number of vertices (0 to 4)
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph example)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        // Run DFS starting from node 0
        List<Integer> dfsResult = dfsOfGraph(0, adj);

        // Print result
        System.out.println("DFS Traversal starting from node 0: " + dfsResult);
    }
}
