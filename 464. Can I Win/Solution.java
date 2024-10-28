class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // If the desired total is 0 or less, the first player automatically wins
        if (desiredTotal <= 0) {
            return true;
        }

        // Calculate the sum of all integers from 1 to maxChoosableInteger
        int maxSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        // If the sum is less than the desired total, it's impossible to reach the
        // desired total
        if (maxSum < desiredTotal) {
            return false;
        }

        // Use a map for memoization to store the results of each state
        Map<Integer, Boolean> memo = new HashMap<>();
        // Start the recursive function with the current state of the game
        return canWin(desiredTotal, 0, maxChoosableInteger, memo);
    }

    private boolean canWin(int total, int usedNumbers, int maxChoosableInteger, Map<Integer, Boolean> memo) {
        // If the current state has been computed before, return the stored result
        if (memo.containsKey(usedNumbers)) {
            return memo.get(usedNumbers);
        }

        // Try picking each number from 1 to maxChoosableInteger
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // Create a bitmask for the current number
            int currentMask = 1 << (i - 1);
            // If the current number is already used, skip it
            if ((usedNumbers & currentMask) != 0) {
                continue;
            }

            // If picking the current number reaches or exceeds the total,
            // or if the opponent cannot win after we pick this number, then we win
            if (i >= total || !canWin(total - i, usedNumbers | currentMask, maxChoosableInteger, memo)) {
                memo.put(usedNumbers, true);
                return true;
            }
        }

        // If no winning move is found, the current player loses
        memo.put(usedNumbers, false);
        return false;
    }
}