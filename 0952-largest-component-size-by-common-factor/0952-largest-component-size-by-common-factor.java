import java.util.*;

class Solution {
    public static int findPar(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findPar(parent[node], parent); // Path compression
    }

    public static void unionByRank(int u, int v, int[] parent, int[] rank) {
        int pu = findPar(u, parent);
        int pv = findPar(v, parent);
        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public int largestComponentSize(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] parent = new int[maxVal + 1];
        int[] rank = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Step 1: For each number, union it with its factors
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    unionByRank(num, factor, parent, rank);
                    unionByRank(num, num / factor, parent, rank);
                }
            }
        }

        // Step 2: Count size of each connected component
        Map<Integer, Integer> count = new HashMap<>();
        int maxSize = 0;
        for (int num : nums) {
            int root = findPar(num, parent);
            count.put(root, count.getOrDefault(root, 0) + 1);
            maxSize = Math.max(maxSize, count.get(root));
        }

        return maxSize;
    }
}
