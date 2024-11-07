class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; // Start with prefix "1"
        k--; // Since we're starting with the first number already

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // Move to the next prefix
                k -= steps;
                curr++;
            } else {
                // Go down one level in the trie
                k--;
                curr *= 10;
            }
        }
        return curr;
    }

    // Helper function to count the steps between prefix1 and prefix2 up to n
    int xx = 0;

    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        xx++;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            // System.out.println(xx + " : " + prefix1 + " : " + prefix2 + " : " + steps);
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}