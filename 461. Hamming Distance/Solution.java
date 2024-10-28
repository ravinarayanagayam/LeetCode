class Solution {
    public int hammingDistance(int x, int y) {
        // XOR the two numbers to find differing bit positions
        int xor = x ^ y;

        // Count the number of 1s in the binary representation of the XOR result
        int distance = 0;
        while (xor != 0) {
            // Increment distance if the last bit is 1
            distance += xor & 1;
            // Right shift the XOR result by 1 bit
            xor >>= 1;
        }
        return distance;
    }
}