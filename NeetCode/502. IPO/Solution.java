import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);

        // Step 1: Combine projects
        for (int i = 0; i < n; i++) {
            minCapital.offer(new int[] { capital[i], profits[i] });
        }

        // Step 2: Pick up to k projects
        for (int i = 0; i < k; i++) {
            // Move affordable projects to maxProfit heap
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfit.offer(minCapital.poll()[1]);
            }

            // If no affordable projects, break
            if (maxProfit.isEmpty())
                break;

            // Pick the most profitable affordable project
            w += maxProfit.poll();
        }

        return w;
    }
}
