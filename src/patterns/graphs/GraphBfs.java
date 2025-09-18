package patterns.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class GraphBfs {
    public static void main(String[] args) {

    }
    public List<Integer> bfsOfGraph(int nodes, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }
}
