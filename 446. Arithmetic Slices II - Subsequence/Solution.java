import java.util.HashMap;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalSlices = 0;

        // Array of hashmaps to store subsequence counts by difference for each index
        HashMap<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            // Compare nums[i] with every previous element nums[j]
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];

                // Number of subsequences ending at j with this difference
                int countAtJ = dp[j].getOrDefault(diff, 0);

                // Update dp[i] for the current difference by extending subsequences from j
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + countAtJ + 1);

                // Add countAtJ to totalSlices because it represents valid subsequences of
                // length >= 3
                totalSlices += countAtJ;
                System.out.println(i + " : " + dp[i] + " : " + countAtJ + " : " + totalSlices + " : " + diff);
            }
        }

        return totalSlices;
    }
}
