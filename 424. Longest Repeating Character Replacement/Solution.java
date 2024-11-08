class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // To store frequency of each character in the current window
        int left = 0, maxLength = 0, maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increment the count of the current character
            char currChar = s.charAt(right);
            count[currChar - 'A']++;

            // Update maxCount to be the highest frequency of any single character in the
            // window
            maxCount = Math.max(maxCount, count[currChar - 'A']);

            // Check if we need to shrink the window
            int windowSize = right - left + 1;
            if (windowSize - maxCount > k) {
                // Reduce the count of the left character and shrink the window
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maxLength to be the largest valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}