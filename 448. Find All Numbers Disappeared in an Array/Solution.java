class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int s = nums[i];
                nums[i] = nums[s - 1];
                nums[s - 1] = s;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                result.add(i + 1);
        }

        return result;

    }
}