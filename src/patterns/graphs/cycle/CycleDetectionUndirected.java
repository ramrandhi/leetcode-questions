package patterns.graphs.cycle;

import java.util.*;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph

public class CycleDetectionUndirected {
    public static boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // undirected graph
        }

        // Step 2: Run BFS for all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.node;
            int parent = p.parent;

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(new Pair(neighbour, node));
                }
                // visited neighbour but not parent → cycle
                else if (neighbour != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int node, parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0,1},{0,2},{1,2},{2,3}
        };
        boolean hasCycleMatrix = isDFSCycle(V, edges);
        System.out.println("Cycle detected using edges? " + hasCycleMatrix);
    }

    public static boolean isDFSCycle(int V, int[][] edges) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for(int i = 0;i<V; i++) adjMatrix.add(new ArrayList<>());
        for(int[] e: edges) {
            adjMatrix.get(e[0]).add(e[1]);
            adjMatrix.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adjMatrix, visited, i, -1)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(List<List<Integer>> adjMatrix, boolean[] visited, int node, int parent) {
        visited[node] = true;
        for(int neighbour: adjMatrix.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(adjMatrix, visited, neighbour, node)) return true;
            } else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
