class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] min = {Integer.MAX_VALUE};
        for (int j = 0; j < n; j++) {
            backtrack(matrix, 0, j, matrix[0][j], min);
        }
        return min[0];
    }

    public void backtrack(int[][] matrix, int i, int j, int sum, int[] min) {
        int n = matrix.length;
        if (i == n - 1) {
            min[0] = Math.min(min[0], sum);
            return;
        }
        if (j > 0) {
            backtrack(matrix, i + 1, j - 1, sum + matrix[i + 1][j - 1], min);
        }
        backtrack(matrix, i + 1, j, sum + matrix[i + 1][j], min);
        if (j < n - 1) {
            backtrack(matrix, i + 1, j + 1, sum + matrix[i + 1][j + 1], min);
        }
    }
}
