class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    private void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Check if a word can be formed by concatenating other words in the Trie
    private boolean canForm(String word, int index, int count) {
        TrieNode current = root;
        for (int i = index; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            if (current.children[charIndex] == null) {
                return false;
            }
            current = current.children[charIndex];
            if (current.isEndOfWord) {
                // If we reach the end of the word, recursively check the rest of the string
                if (i == word.length() - 1) {
                    return count >= 1; // At least two words are needed
                }
                if (canForm(word, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Insert all words into the Trie
        for (String word : words) {
            if (!word.isEmpty()) {
                insert(word);
            }
        }

        List<String> result = new ArrayList<>();
        // Check each word to see if it can be formed by concatenating other words
        for (String word : words) {
            if (canForm(word, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }
}