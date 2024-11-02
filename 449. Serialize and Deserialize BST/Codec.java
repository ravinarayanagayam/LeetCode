public class Codec {
    int index;

    // Serialize the tree to a single string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().trim();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val).append(" ");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize the string back to a tree
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data.isEmpty())
            return null;
        String[] values = data.split(" ");
        // int[] index = {0}; // Array to maintain current index during recursion
        return deserializeHelper(values, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(String[] values, int max) {
        if (index >= values.length)
            return null;
        int val = Integer.parseInt(values[index]);
        // Check if the current value fits the BST property
        if (val > max)
            return null;
        // If it fits, we create the node and move the index forward
        TreeNode node = new TreeNode(val);
        index++;
        // Recursively construct the left and right subtrees
        node.left = deserializeHelper(values, val);
        node.right = deserializeHelper(values, max);

        return node;
    }
}
