class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0; // Not enough elements to form an arithmetic slice

        int total = 0;
        int current = 0; // Tracks number of slices ending at current position

        // Start from the third element to check for arithmetic properties
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                current += 1;
                total += current;
            } else {
                current = 0; // Reset if not arithmetic
            }
        }

        return total;
    }
}
