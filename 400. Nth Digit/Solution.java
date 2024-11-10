class Solution {
    public int findNthDigit(int n) {
        int length = 1; // digit length (1 for 1-digit, 2 for 2-digit, etc.)
        long count = 9; // number of integers in the current range (9 for 1-digit, 90 for 2-digit, etc.)
        int start = 1; // starting number in the current range (1, 10, 100, etc.)

        // Find the range that contains the nth digit
        while (n > length * count) {
            n -= length * count;
            length++; // Move to the next length (2 for two-digit numbers, etc.)
            count *= 10; // Update count for the next range
            start *= 10; // Update start to the first number in the new range
        }

        // Find the exact number and then the digit within that number
        int num = start + (n - 1) / length; // Exact number containing the nth digit
        String numStr = Integer.toString(num); // Convert number to string to find the digit
        return numStr.charAt((n - 1) % length) - '0'; // Get the nth digit and return as integer
    }
}
