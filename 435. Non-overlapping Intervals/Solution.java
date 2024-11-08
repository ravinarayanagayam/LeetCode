class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int countRemovals = 0;
        int lastEnd = intervals[0][1];

        // Start from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the last selected interval's end,
            // remove it
            if (intervals[i][0] < lastEnd) {
                countRemovals++;
            } else {
                // Otherwise, update lastEnd to the current interval's end
                lastEnd = intervals[i][1];
            }
        }

        return countRemovals;
    }
}