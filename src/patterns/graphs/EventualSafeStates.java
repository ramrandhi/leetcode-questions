package patterns.graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    // any one who is part of the cycle is not a safe node
    // any one who leads to a cycle is not a safe node.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safe = new boolean[n];
        for(int i = 0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, graph, visited, pathVisited, safe);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            if(safe[i]) list.add(i);
        }
        return list;
    }
    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] safe) {
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour: graph[node]) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, graph, visited, pathVisited, safe)) {
                    return true;
                }
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }
        pathVisited[node] = false;
        safe[node] = true;
        return false;
    }


    // bfs with topological sort
    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     int n = graph.length;
    //     List<List<Integer>> list = new ArrayList<>();
    //     for(int i = 0;i<n;i++) list.add(new ArrayList<>());
    //     int[] inDegree = new int[n];
    //     for(int u=0;u<n;u++) {
    //         for(int v: graph[u]) {
    //             list.get(v).add(u);
    //             inDegree[u]++;
    //         }
    //     }

    //     Queue<Integer> queue = new LinkedList<>();
    //     for(int i = 0;i<n;i++) {
    //         if(inDegree[i] == 0) {
    //             queue.add(i);
    //         }
    //     }
    //     List<Integer> returningList = new ArrayList<>();
    //     while(!queue.isEmpty()) {
    //         int node = queue.poll();
    //         returningList.add(node);
    //         for(int neighbour: list.get(node)) {
    //             inDegree[neighbour]--;
    //             if(inDegree[neighbour] == 0) {
    //                 queue.add(neighbour);
    //             }
    //         }
    //     }
    //     Collections.sort(returningList);
    //     return returningList;
    // }
}
