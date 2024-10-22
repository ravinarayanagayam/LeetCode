public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Step 1: Remove all dashes and convert to uppercase
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                cleaned.append(Character.toUpperCase(c));
            }
        }

        // Step 2: Reformat the string into groups of length k
        StringBuilder formatted = new StringBuilder();
        int length = cleaned.length();
        int firstGroupLength = length % k;

        // Add the first group if it's not empty
        if (firstGroupLength > 0) {
            formatted.append(cleaned.substring(0, firstGroupLength));
        }

        // Add the remaining groups of size k
        for (int i = firstGroupLength; i < length; i += k) {
            if (formatted.length() > 0) {
                formatted.append("-");
            }
            formatted.append(cleaned.substring(i, i + k));
        }

        return formatted.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "5F3Z-2e-9-w";
        int k1 = 4;
        System.out.println(solution.licenseKeyFormatting(s1, k1)); // Output: "5F3Z-2E9W"

        // Test case 2
        String s2 = "2-5g-3-J";
        int k2 = 2;
        System.out.println(solution.licenseKeyFormatting(s2, k2)); // Output: "2-5G-3J"
    }

}
