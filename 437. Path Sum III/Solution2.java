import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // HashMap to store the prefix sums and their counts
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case: single path with targetSum equal to the node value
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, int currentSum, int targetSum, HashMap<Integer, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Update the current path sum
        currentSum += node.val;

        // Check how many times (currentSum - targetSum) has occurred
        int pathsToCurrent = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum map with the current path sum
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recurse through left and right children
        int result = pathsToCurrent
                + dfs(node.left, currentSum, targetSum, prefixSumMap)
                + dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: remove the current path sum count from the map
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return result;
    }
}
