class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long coinsNeeded = (long) mid * (mid + 1) / 2; // Use long to avoid overflow

            if (coinsNeeded == n) {
                return mid; // Exact match
            } else if (coinsNeeded < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right; // 'right' will be the largest k for which the sum is <= n
    }
}
