import java.util.*;

class SearchSuggestionsSystem {
    // Define TrieNode
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 lowercase English letters
        List<String> suggestions = new ArrayList<>(); // Stores up to 3 suggestions
    }

    private TrieNode root;

    // Constructor to initialize Trie
    public SearchSuggestionsSystem() {
        root = new TrieNode();
    }

    // Insert a product into the Trie
    private void insert(String product) {
        TrieNode current = root;
        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            // Add the product to the suggestions list if there are fewer than 3 entries
            if (current.suggestions.size() < 3) {
                current.suggestions.add(product);
            }
        }
    }

    // Generate suggestions for each prefix of searchWord
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort products lexicographically
        Arrays.sort(products);

        // Insert products into the Trie
        for (String product : products) {
            insert(product);
        }

        // Find suggestions for each prefix
        List<List<String>> result = new ArrayList<>();
        TrieNode current = root;

        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (current != null && current.children[index] != null) {
                current = current.children[index];
                result.add(current.suggestions);
            } else {
                current = null; // No further suggestions possible
                result.add(new ArrayList<>()); // Add an empty list
            }
        }

        return result;
    }

    // Main function to test the system
    public static void main(String[] args) {
        SearchSuggestionsSystem system = new SearchSuggestionsSystem();
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";

        List<List<String>> suggestions = system.suggestedProducts(products, searchWord);
        System.out.println(suggestions);
    }
}
