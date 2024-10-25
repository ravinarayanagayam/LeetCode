class Solution {
    public int findComplement(int num) {
        // Find the number of bits in the binary representation of num
        int bitLength = Integer.toBinaryString(num).length();

        // Create a mask with all bits set to 1 of the same length as num
        int mask = (1 << bitLength) - 1;

        // XOR num with the mask to get the complement
        return num ^ mask;
    }
}