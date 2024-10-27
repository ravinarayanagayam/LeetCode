public class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] count = new int[26]; // Array to store max length of substrings ending with each character
        int n = s.length();
        int currentLength = 0; // Length of current valid substring

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            // Check if the current character extends the previous character in the cyclic
            // order
            if (i > 0 && (currentChar - s.charAt(i - 1) == 1 || currentChar - s.charAt(i - 1) == -25)) {
                currentLength++;
            } else {
                currentLength = 1; // Reset the length if the sequence breaks
            }

            // Update the count for the current character
            int index = currentChar - 'a';
            count[index] = Math.max(count[index], currentLength);
        }

        // Sum all values in the count array to get the total number of unique
        // substrings
        int result = 0;
        for (int length : count) {
            result += length;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
        System.out.println(solution.findSubstringInWraproundString("a")); // Output: 1
        System.out.println(solution.findSubstringInWraproundString("cac")); // Output: 2
        System.out.println(solution.findSubstringInWraproundString("zab")); // Output: 6
    }
}
