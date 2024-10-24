public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9; // Special case: when n = 1, the largest palindrome is 9 (9*1).
        }

        int upperLimit = (int) Math.pow(10, n) - 1; // Largest n-digit number
        int lowerLimit = (int) Math.pow(10, n - 1); // Smallest n-digit number

        for (int leftHalf = upperLimit; leftHalf >= lowerLimit; leftHalf--) {
            // Create the palindrome from leftHalf
            long palindrome = createPalindrome(leftHalf);

            // Try to factor the palindrome into two n-digit numbers
            for (long i = upperLimit; i * i >= palindrome; i--) {
                if (palindrome % i == 0) {
                    long otherFactor = palindrome / i;
                    if (otherFactor >= lowerLimit && otherFactor <= upperLimit) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }
        return -1;
    }

    // Helper function to create a palindrome from the left half
    private long createPalindrome(int leftHalf) {
        String str = Integer.toString(leftHalf);
        String reverseStr = new StringBuilder(str).reverse().toString();
        return Long.parseLong(str + reverseStr);
    }
}
