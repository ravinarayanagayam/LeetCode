//Time Limit Exceeded
class Solution {
    public int splitArray(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++)
            sums[i + 1] = sums[i] + nums[i];
        if (k > nums.length)
            return sums[nums.length];
        return find(sums, k, 1);
    }

    HashMap<String, Integer> cache = new HashMap();

    private int find(int[] sums, int k, int startIndex) {
        // System.out.println(k+":"+startIndex);
        if (startIndex >= sums.length)
            return 0;
        if (k == 1)
            return sums[sums.length - 1] - sums[startIndex - 1];
        if (cache.containsKey(k + ":" + startIndex))
            return cache.get(k + ":" + startIndex);
        int min = Integer.MAX_VALUE;
        for (int i = startIndex; i <= sums.length - k; i++) {
            int max = Math.max(sums[i] - sums[startIndex - 1], find(sums, k - 1, i + 1));
            min = Math.min(min, max);
        }
        cache.put(k + ":" + startIndex, min);
        return min;
    }
}