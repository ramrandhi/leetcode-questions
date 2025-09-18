package patterns.graphs.shortestPath;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbour: adj.get(node)) {
                if(dist[neighbour] == -1) {  // thi means not visited
                    dist[neighbour] = dist[node] + 1;
                    queue.add(neighbour);
                }
            }
        }
        return dist;
    }
}
