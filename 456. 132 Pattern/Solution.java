class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int third = Integer.MIN_VALUE; // Holds the "2" in the pattern
        Stack<Integer> stack = new Stack<>(); // Stack to hold potential "3" elements
        // Traverse from the end of the array
        for (int i = nums.length - 1; i >= 0; i--) {
            // If nums[i] is less than the second, we have found the 132 pattern
            if (nums[i] < third) {
                return true;
            }
            // Update "third" with larger values from the stack to maintain a valid 132
            // pattern
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            // Push the current element as a potential "3" element
            stack.push(nums[i]);
        }

        return false; // No 132 pattern found
    }
}