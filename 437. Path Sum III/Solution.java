/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        ArrayList<Long> all = new ArrayList<Long>();
        ArrayList<Long> alr = new ArrayList<Long>();
        all.add((long) root.val);
        alr.add((long) root.val);
        int c = root.val == targetSum ? 1 : 0;

        return c + pathSum(root.left, targetSum, all) + pathSum(root.right, targetSum, alr);

    }

    public int pathSum(TreeNode root, int targetSum, ArrayList<Long> al) {
        // System.out.println(al);
        if (root == null)
            return 0;

        int c = root.val == targetSum ? 1 : 0;

        for (int i = 0; i < al.size(); i++) {
            long a = al.get(i);
            if (a + root.val == targetSum)
                c++;
            al.set(i, a + root.val);
        }
        al.add((long) root.val);
        ArrayList<Long> all = new ArrayList<Long>();
        ArrayList<Long> alr = new ArrayList<Long>();
        all.addAll(al);
        alr.addAll(al);

        return c + pathSum(root.left, targetSum, all) + pathSum(root.right, targetSum, alr);

    }

}