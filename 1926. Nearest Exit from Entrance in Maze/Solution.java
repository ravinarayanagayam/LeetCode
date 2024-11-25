class Solution {
    public int nearestExit(char[][] grid, int[] entrance) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> paths = new LinkedList();
        paths.add(entrance);
        grid[entrance[0]][entrance[1]] = '+';
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int depth = 0;

        while (!paths.isEmpty()) {
            depth++;
            int size = paths.size();
            for (int i = 0; i < size; i++) {
                int[] first = paths.removeFirst();
                for (int[] d : directions) {
                    int x = first[0] + d[0];
                    int y = first[1] + d[1];
                    if (x < m && x >= 0 && y >= 0 && y < n && grid[x][y] == '.') {
                        // System.out.println(x+":"+y);
                        if (x == 0 || y == 0 || y == n - 1 || x == m - 1)
                            return depth;
                        int[] c = { x, y };
                        paths.add(c);
                        grid[x][y] = '+';
                    }
                }
            }
        }

        return -1;

    }
}