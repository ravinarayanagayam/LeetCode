class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result; // If s is shorter than p, no anagrams possible
        }

        // Frequency arrays for p and the current window in s
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill the pCount array with character frequencies of p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Initial window in s (first p.length() characters)
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the initial window is an anagram
        if (matches(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window over the rest of s
        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character at the end of the window
            sCount[s.charAt(i) - 'a']++;
            // Remove the character at the start of the window
            sCount[s.charAt(i - p.length()) - 'a']--;

            // Check if the current window is an anagram
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}