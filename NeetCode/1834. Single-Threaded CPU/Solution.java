import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] extendedTasks = new int[n][3];

        // Attach original indices to each task
        for (int i = 0; i < n; i++) {
            extendedTasks[i][0] = tasks[i][0]; // enqueueTime
            extendedTasks[i][1] = tasks[i][1]; // processingTime
            extendedTasks[i][2] = i; // original index
        }

        // Sort by enqueueTime
        Arrays.sort(extendedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap based on processingTime, then index
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int time = 0, i = 0, idx = 0;
        int[] result = new int[n];

        while (i < n || !heap.isEmpty()) {
            // Load all available tasks into heap
            while (i < n && extendedTasks[i][0] <= time) {
                heap.offer(new int[] { extendedTasks[i][0], extendedTasks[i][1], extendedTasks[i][2] });
                i++;
            }

            if (!heap.isEmpty()) {
                int[] task = heap.poll();
                time += task[1]; // process it
                result[idx++] = task[2];
            } else {
                // No tasks are available, jump time to next task
                time = extendedTasks[i][0];
            }
        }

        return result;
    }
}
