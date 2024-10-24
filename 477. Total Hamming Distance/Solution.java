public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        // Iterate over each bit position (0 to 31)
        for (int bit = 0; bit < 32; bit++) {
            int countOnes = 0;

            // Count the number of '1's at the current bit position
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    countOnes++;
                }
            }

            // Calculate the number of '0's at the current bit position
            int countZeros = n - countOnes;

            // Add to the total Hamming distance the number of differing pairs
            total += countOnes * countZeros;
        }

        return total;
    }
}
