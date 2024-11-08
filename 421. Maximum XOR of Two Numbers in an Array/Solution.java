class Solution {
    // Define the Trie Node class
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root = new TrieNode();

    // Function to insert a number into the Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Function to find the maximum XOR for a number
    private int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            // Check the opposite bit for maximizing XOR
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXOR |= (1 << i); // Set the bit in maxXOR
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }

    public int findMaximumXOR(int[] nums) {
        // Build the Trie with all numbers
        for (int num : nums) {
            insert(num);
        }

        int maxResult = 0;
        // Compute max XOR for each number
        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXOR(num));
        }

        return maxResult;
    }
}
