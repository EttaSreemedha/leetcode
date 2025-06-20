class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int max = 0;

        // Skip one stone each time (like zigzag path)
        for (int i = 2; i < n; i++) {
            max = Math.max(max, stones[i] - stones[i - 2]);
        }

        // Also check the last two (edge case for small n)
        for (int i = 1; i < n; i++) {
            max = Math.max(max, stones[i] - stones[i - 1]);
        }

        return max;
    }
}
