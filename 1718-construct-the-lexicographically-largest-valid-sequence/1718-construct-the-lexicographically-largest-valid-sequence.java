class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2 - 1]; // Final array (size 2n - 1)
        boolean[] visited = new boolean[n + 1]; // visited[i] is true if i has been placed
        calc(0, ans, visited, n); // Start backtracking from index 0
        return ans;
    }

    boolean calc(int index, int[] ans, boolean[] visited, int n) {
        if (index == ans.length) return true; // Base case: filled entire array

        if (ans[index] != 0) // If current index is already filled, skip to next
            return calc(index + 1, ans, visited, n);

        for (int i = n; i >= 1; i--) { // Try placing numbers from n to 1 (for largest)
            if (visited[i]) continue; // Skip already placed numbers

            visited[i] = true; // Mark i as used
            ans[index] = i;    // Place i at current index

            if (i == 1) {
                // 1 only appears once, just move on
                if (calc(index + 1, ans, visited, n)) return true;
            } else if (index + i < ans.length && ans[index + i] == 0) {
                // Try placing i again at (index + i) if within bounds and empty
                ans[index + i] = i;
                if (calc(index + 1, ans, visited, n)) return true;
                ans[index + i] = 0; // Backtrack second placement
            }

            ans[index] = 0;       // Backtrack first placement
            visited[i] = false;   // Unmark i
        }

        return false; // No valid placement at this index
    }
}
