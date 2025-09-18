package patterns.graphs.topologicalSort;

import java.util.Stack;

// it is a algorithm works for DAG -> directed acyclic graph.
/* Defination ->
    Linear ordering of vertices such that if there is an edge between u and v, u always appears before v in that ordering.

 */
public class TopologicalSortDfs {
    public static int[] topologicalsort(int[][] graph) {
        int n = graph.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, graph, stack, visited);
            }
        }
        int[] num = new int[n];
        int index = 0;
        while(!stack.isEmpty()) {
            num[index] = stack.pop();
        }
        return num;
    }

    private static void dfs(int node, int[][] graph, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for(int neighbour: graph[node]) {
            if(!visited[neighbour]) {
                dfs(neighbour, graph, stack, visited);
            }
        }
        stack.push(node);
    }
}
