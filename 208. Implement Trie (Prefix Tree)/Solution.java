class TrieNode {
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null)
            return;
        TrieNode dummyroot = root;
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.isEnd = true;
        root = dummyroot;
    }

    public boolean search(String word) {
        if (word == null)
            return false;
        TrieNode dummyroot = root;
        for (char c : word.toCharArray()) {
            if (dummyroot.children[c - 'a'] == null) {
                return false;
            }
            dummyroot = dummyroot.children[c - 'a'];
        }
        return dummyroot.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null)
            return false;
        TrieNode dummyroot = root;
        for (char c : prefix.toCharArray()) {
            if (dummyroot.children[c - 'a'] == null) {
                return false;
            }
            dummyroot = dummyroot.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */