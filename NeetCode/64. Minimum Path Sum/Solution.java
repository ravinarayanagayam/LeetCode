class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 1; i < columns; i++)
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        for (int i = 1; i < rows; i++)
            grid[i][0] = grid[i - 1][0] + grid[i][0];

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < columns; j++)
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);

        return grid[rows - 1][columns - 1];
    }
}