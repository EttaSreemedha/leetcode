class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] dir = {{1, 0}, {0, 1}}; 
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0});
        grid[0][0] = 1; 

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (grid[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    }
                    grid[nx][ny] += grid[x][y];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
