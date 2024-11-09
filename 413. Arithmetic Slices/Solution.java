class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int start = 0;
        int diff = nums[1] - nums[0];
        int result = 0;
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff)
                continue;
            end = i - 1;

            if (end - start >= 2) {
                int n = (end - start + 1) - 3 + 1;
                result += ((n * (n + 1)) / 2);
            }

            start = i - 1;
            diff = nums[i] - nums[i - 1];
        }
        if (end == 0 || start > 0) {
            end = nums.length - 1;
            // System.out.print(end);
            if (end - start >= 2) {
                int n = (end - start + 1) - 3 + 1;
                result += ((n * (n + 1)) / 2);
            }
        }
        return result;
    }
}