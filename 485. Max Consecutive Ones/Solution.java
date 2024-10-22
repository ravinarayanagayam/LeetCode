class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int result = 0;

        int temp = 0;
        for (int i : nums) {
            if (i == 0) {
                result = Math.max(result, temp);
                temp = 0;
            } else {
                temp++;
            }
        }

        return Math.max(result, temp);

    }
}