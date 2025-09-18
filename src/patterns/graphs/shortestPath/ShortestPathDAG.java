package patterns.graphs.shortestPath;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adjcentList = new ArrayList<>();
        for(int i = 0;i<V;i++) adjcentList.add(new ArrayList<>());
        for(int i = 0;i<E;i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            int weight = edges[i][2];
            adjcentList.get(v).add(new Pair(u, weight));
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++) {
            if(!visited[i]) {
                topoSort(i, adjcentList, stack, visited);
            }
        }
        int INF = (int)1e9;
        int[] dist = new int[V];
        for(int i = 0;i<V;i++) {
            dist[i] = INF;
        }
        dist[0] = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(dist[node] != INF) {
                for(Pair neighbour: adjcentList.get(node)) {
                    int pointingTo = neighbour.first;
                    int weight = neighbour.second;
                    if(dist[node] + weight < dist[pointingTo]) {
                        dist[pointingTo] = dist[node] + weight;
                    }
                }
            }
        }
        for(int i = 0;i<V;i++) {
            if(dist[i] == INF) dist[i] = -1;
        }
        return dist;
    }
    private void topoSort(int node, List<List<Pair>> adjcentList, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for(Pair neighbour: adjcentList.get(node)) {
            int first = neighbour.first;
            if(!visited[first]) {
                topoSort(first, adjcentList, stack, visited);
            }
        }
        stack.push(node);
    }

    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
