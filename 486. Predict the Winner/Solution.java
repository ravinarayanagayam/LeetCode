public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n]; // Memoization table

        // Helper function to calculate the maximum score difference
        int scoreDifference = dfs(nums, 0, n - 1, memo);
        return scoreDifference >= 0;
    }

    private int dfs(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) {
            return nums[left]; // Only one element left
        }

        if (memo[left][right] != null) {
            return memo[left][right]; // Return the memoized result
        }

        // Choose the left element or the right element
        int chooseLeft = nums[left] - dfs(nums, left + 1, right, memo);
        int chooseRight = nums[right] - dfs(nums, left, right - 1, memo);

        // Take the maximum score difference that can be achieved
        memo[left][right] = Math.max(chooseLeft, chooseRight);
        return memo[left][right];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 1, 5, 2 };
        System.out.println(solution.PredictTheWinner(nums1)); // Output: false

        // Test case 2
        int[] nums2 = { 1, 5, 233, 7 };
        System.out.println(solution.PredictTheWinner(nums2)); // Output: true
    }
}
