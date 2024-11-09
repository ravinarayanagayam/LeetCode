class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        // Set the initial bounds for binary search
        for (int num : nums) {
            left = Math.max(left, num); // the largest single element
            right += num; // the sum of all elements
        }

        // Binary search for the minimum largest sum
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if we can split into k or fewer subarrays with max sum <= mid
            if (canSplit(nums, k, mid)) {
                right = mid; // possible candidate, try for smaller max sum
            } else {
                left = mid + 1; // need larger max sum
            }
        }

        return left; // or right, since left == right here
    }

    // Helper function to check if we can split into k subarrays with max sum <=
    // maxSum
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrayCount = 1; // start with one subarray
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                // Need to start a new subarray
                subarrayCount++;
                currentSum = num;

                // If more than k subarrays are required, return false
                if (subarrayCount > k) {
                    return false;
                }
            }
        }

        return true; // Successfully split within k subarrays
    }
}
