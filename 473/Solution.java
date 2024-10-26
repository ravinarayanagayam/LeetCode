class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;
        for (int stick : matchsticks) {
            totalLength += stick;
        }

        // If the total length is not divisible by 4, we can't form a square
        if (totalLength % 4 != 0) {
            return false;
        }

        int targetLength = totalLength / 4;
        // Sort the matchsticks in descending order to optimize the backtracking
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        // Array to keep track of the length of each side
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, targetLength);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int index, int targetLength) {
        // If we've considered all matchsticks, check if all four sides are equal to the
        // target length
        if (index == matchsticks.length) {
            return sides[0] == targetLength && sides[1] == targetLength &&
                    sides[2] == targetLength && sides[3] == targetLength;
        }

        // Try to place the current matchstick in each of the four sides
        for (int i = 0; i < 4; i++) {
            // If adding matchsticks[index] would exceed the target length, skip
            if (sides[i] + matchsticks[index] > targetLength) {
                continue;
            }

            // Add the matchstick to side i
            sides[i] += matchsticks[index];
            // Recursively try to place the next matchstick
            if (backtrack(matchsticks, sides, index + 1, targetLength)) {
                return true;
            }
            // If placing matchstick[index] in side i doesn't work, backtrack
            sides[i] -= matchsticks[index];

            // If a side is still 0 after trying to place a matchstick, no need to try
            // further sides
            if (sides[i] == 0) {
                break;
            }
        }
        return false;
    }

}
