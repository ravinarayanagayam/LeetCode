class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int l = intervals.length;
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int[] startPos = new int[l];
        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            cache.put(intervals[i][0], i);
            startPos[i] = intervals[i][0];
        }

        Arrays.sort(startPos);

        for (int i = 0; i < l; i++) {
            int pos = Arrays.binarySearch(startPos, intervals[i][1]);
            if (pos >= 0) {
                result[i] = cache.get(startPos[pos]);
            } else {
                pos = Math.abs(pos) - 1;
                if (pos == l)
                    result[i] = -1;
                else
                    result[i] = cache.get(startPos[pos]);
            }
        }
        return result;
    }
}