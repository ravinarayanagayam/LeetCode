import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false; // If first jump of 1 can't reach the second stone

        // Map to store possible jump distances for each stone
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0); // Frog starts at stone 0 with 0 distance initially

        for (int stone : stones) {
            Set<Integer> jumps = dp.get(stone);
            for (int jump : jumps) {
                for (int nextJump : new int[] { jump - 1, jump, jump + 1 }) {
                    if (nextJump > 0 && dp.containsKey(stone + nextJump)) {
                        dp.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
