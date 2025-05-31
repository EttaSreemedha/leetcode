class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0, rows = grid.length, cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        for (int[] dir : directions) {
                            int x = cell[0] + dir[0], y = cell[1] + dir[1];
                            if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
