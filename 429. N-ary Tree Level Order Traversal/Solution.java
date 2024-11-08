/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        ArrayList<Node> level = new ArrayList();
        ArrayList<Integer> levelResult = new ArrayList();
        level.add(root);
        while (!level.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList();
            levelResult = new ArrayList();
            while (!level.isEmpty()) {
                levelResult.add(level.get(0).val);
                if (level.get(0).children != null)
                    nextLevel.addAll(level.get(0).children);
                level.remove(0);
            }
            result.add(levelResult);
            level.addAll(nextLevel);
        }
        return result;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                for (Node child : currentNode.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}