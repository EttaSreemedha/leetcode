class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

       
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return burst(balloons, 1, n, dp);
    }

    private int burst(int[] a, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int maxi = 0;

        for (int ind = i; ind <= j; ind++) {
            int coins = a[i - 1] * a[ind] * a[j + 1]
                      + burst(a, i, ind - 1, dp)
                      + burst(a, ind + 1, j, dp);

            maxi = Math.max(maxi, coins);
        }

        return dp[i][j] = maxi;
    }
}
