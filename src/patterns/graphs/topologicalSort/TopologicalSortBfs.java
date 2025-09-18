package patterns.graphs.topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBfs {
    public static int[] topologicalsort(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];

        // Step 1: calculate indegrees
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                inDegree[v]++;
            }
        }

        // Step 2: add nodes with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);   // ✅ add node, not indegree
            }
        }

        // Step 3: process queue
        int[] topo = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[idx++] = node;

            for (int nei : graph[node]) {
                inDegree[nei]--;   // ✅ decrease neighbor’s indegree
                if (inDegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        // Optional: check for cycle
        if (idx < n) {
            throw new IllegalStateException("Graph has a cycle, topo order not possible");
        }

        return topo;
    }
}
