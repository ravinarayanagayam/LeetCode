import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] starts = new int[n][2]; // To store start points and their indices

        // Populate the starts array with start points and original indices
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start point
            starts[i][1] = i; // original index
        }

        // Sort by start points
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        // For each interval, find the smallest start >= end using binary search
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(starts, end);

            // If idx is within bounds, return the corresponding original index, else -1
            result[i] = (idx == n) ? -1 : starts[idx][1];
        }

        return result;
    }

    // Binary search to find the smallest start >= end
    private int binarySearch(int[][] starts, int end) {
        int left = 0, right = starts.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (starts[mid][0] >= end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
