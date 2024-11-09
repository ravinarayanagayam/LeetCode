class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;

        for (int num : nums) {
            // Skip if the number is already in one of the max variables
            if ((first != null && num == first)
                    || (null != second && num == second)
                    || (null != third && num == third))
                continue;

            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        // Return third max if it exists; otherwise return first max
        return third == null ? first : third;
    }
}
