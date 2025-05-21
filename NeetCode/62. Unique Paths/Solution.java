class Solution {
    public int uniquePaths(int m, int n) {

        if (m == 1 || n == 1)
            return 1;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < m; i++) {
            // dp[0] = dp[0]+1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];

    }
}