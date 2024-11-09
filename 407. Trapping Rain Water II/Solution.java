import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2)
            return 0; // No space to trap water in smaller grids

        // Min-heap to always process the lowest boundary first
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Visited array to keep track of processed cells
        boolean[][] visited = new boolean[m][n];

        // Initialize the boundaries
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { i, 0, heightMap[i][0] });
            pq.offer(new int[] { i, n - 1, heightMap[i][n - 1] });
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[] { 0, j, heightMap[0][j] });
            pq.offer(new int[] { m - 1, j, heightMap[m - 1][j] });
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions for the 4 neighbors (up, down, left, right)
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        int waterTrapped = 0;

        // Process the queue
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0], col = cell[1], height = cell[2];

            // Check all 4 neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Continue if out of bounds or already visited
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                // Calculate water trapped for the neighbor
                int neighborHeight = heightMap[newRow][newCol];
                if (height > neighborHeight) {
                    waterTrapped += height - neighborHeight;
                }

                // Update the neighbor's height and add to heap
                pq.offer(new int[] { newRow, newCol, Math.max(height, neighborHeight) });
                visited[newRow][newCol] = true;
            }
        }

        return waterTrapped;
    }
}
