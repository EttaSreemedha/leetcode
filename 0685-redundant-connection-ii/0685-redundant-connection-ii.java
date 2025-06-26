import java.util.*;

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, Integer> parentMap = new HashMap<>();
        int[] cand1 = null, cand2 = null;

        // Step 1: Find if a node has two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (parentMap.containsKey(v)) {
                cand1 = new int[]{parentMap.get(v), v}; // first edge
                cand2 = new int[]{u, v};                // second edge
                edge[1] = 0; // mark to skip later
            } else {
                parentMap.put(v, u);
            }
        }

        // Step 2: Use Union-Find to find a cycle
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue; // skip the marked second parent edge

            int pu = find(u, parent);
            int pv = find(v, parent);

            if (pu == pv) {
                // found a cycle
                if (cand1 != null) return cand1; // two parents + cycle
                return edge; // only cycle
            }

            parent[pv] = pu;
        }

        // No cycle, but two parents → remove second one
        return cand2;
    }

    private int find(int x, int[] parent) {
        if (x != parent[x])
            parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
