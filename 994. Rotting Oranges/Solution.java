class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        LinkedList<int[]> rotten = new LinkedList();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int[] c = { i, j };
                    rotten.add(c);
                    grid[i][j] = 0;
                }
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int depth = 0;

        // if(rotten.isEmpty()) return -1;

        while (!rotten.isEmpty()) {
            depth++;
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] first = rotten.removeFirst();
                for (int[] d : directions) {
                    int x = first[0] + d[0];
                    int y = first[1] + d[1];
                    if (x < m && x >= 0 && y >= 0 && y < n && grid[x][y] == 1) {
                        int[] c = { x, y };
                        rotten.add(c);
                        grid[x][y] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return depth == 0 ? 0 : depth - 1;

    }
}