//Time Limit Exceeded

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;

        Arrays.sort(nums);
        return check(nums, sum / 2, 0, 0);
    }

    private boolean check(int[] nums, int sum, int start, int sumSoFar) {
        if (sum == sumSoFar)
            return true;
        if (start >= nums.length)
            return false;
        if (sumSoFar + nums[start] > sum)
            return false;
        return check(nums, sum, start + 1, sumSoFar + nums[start]) || check(nums, sum, start + 1, sumSoFar);

    }

}