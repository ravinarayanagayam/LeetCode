public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the largest j <= target such that dp[j] is true
        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return total - 2 * j;
            }
        }

        return 0; // Just for completeness
    }
}
<<<<<<< HEAD
/*
 * Approach:
 * Let totalSum = sum(stones).
 * 
 * The goal is to find a subset whose sum is as close as possible to totalSum /
 * 2.
 * 
 * Once we find such a subset (say subsetSum), the other subset will have sum
 * totalSum - subsetSum.
 * 
 * The answer will be: totalSum - 2 * subsetSum.
 * 
 * This is the classic 0/1 Knapsack problem.
 */
=======
>>>>>>> origin/main
