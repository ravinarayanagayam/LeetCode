class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // DP array to store the maximum number of strings for a given number of 0's and
        // 1's
        int[][] dp = new int[m + 1][n + 1];

        // Iterate over each string in the array
        for (String s : strs) {
            // Count the number of zeros and ones in the current string
            int count0 = 0, count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0')
                    count0++;
                else
                    count1++;
            }

            // Update the DP array from bottom right to top left
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }

        // The result is stored in dp[m][n], which gives the maximum number of strings
        return dp[m][n];
    }
}