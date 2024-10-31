class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCount = new HashMap<>();

        // Populate sumCount with sums of nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Check for complementary sums in nums3 and nums4
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                count += sumCount.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}