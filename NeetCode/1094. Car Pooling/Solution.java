class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        PriorityQueue<int[]> events = new PriorityQueue<int[]>((a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[2] - b[2]));
        for (int[] trip : trips) {
            events.offer(new int[] { trip[1], trip[0], 1 });
            events.offer(new int[] { trip[2], trip[0], -1 });
        }

        int current = 0;
        while (!events.isEmpty()) {
            int[] event = events.poll();
            if (event[2] == 1) {
                current = current + event[1];
            } else {
                current = current - event[1];
            }
            if (current > capacity)
                return false;
        }

        return true;
    }
}