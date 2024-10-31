class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        // Calculate the minimum value and the sum of all elements
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        // Minimum moves to make all elements equal
        return sum - min * nums.length;
    }
}