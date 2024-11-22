class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TrieNode root = new TrieNode();

        for (String s : products) {
            TrieNode dummy = root;
            for (Character c : s.toCharArray()) {
                if (!dummy.children.containsKey(c)) {
                    dummy.children.put(c, new TrieNode());
                }
                dummy = dummy.children.get(c);
                dummy.topThree.add(s);
                if (dummy.topThree.size() > 3) {
                    dummy.topThree.pollLast();
                }
            }
        }
        // System.out.println(root);
        ArrayList<List<String>> result = new ArrayList();
        for (char c : searchWord.toCharArray()) {
            if (root.children.containsKey(c)) {
                root = root.children.get(c);
                ArrayList<String> r = new ArrayList();
                while (!root.topThree.isEmpty()) {
                    r.add(root.topThree.pollFirst());
                }
                result.add(r);
            } else {
                break;
            }
        }
        while (result.size() < searchWord.length())
            result.add(new ArrayList<String>());
        return result;

    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    TreeSet<String> topThree;

    TrieNode() {
        children = new HashMap<Character, TrieNode>();
        topThree = new TreeSet<String>();
    }
}