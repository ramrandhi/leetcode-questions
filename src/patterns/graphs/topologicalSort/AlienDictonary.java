package patterns.graphs.topologicalSort;

import java.util.*;

public class AlienDictonary {
    public String findOrder(String[] words) {
        int N = words.length;

        // Step 1: Find all unique characters
        Set<Character> set = new HashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                set.add(c);
            }
        }
        int K = set.size();

        // Map each character to an index
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> reverseMap = new HashMap<>();
        int idx = 0;
        for (char c : set) {
            map.put(c, idx);
            reverseMap.put(idx, c);
            idx++;
        }

        // Step 2: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            // Edge case: invalid dictionary like ["abc","ab"]
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(map.get(s1.charAt(j))).add(map.get(s2.charAt(j)));
                    break;
                }
            }
        }

        // Step 3: Topological Sort (Kahn’s Algorithm)
        int[] indegree = new int[K];
        for (int u = 0; u < K; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(reverseMap.get(node));
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.add(nei);
            }
        }

        // Cycle detection: if topo sort doesn't include all chars
        if (sb.length() < K) return "";

        return sb.toString();
    }
}
