import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            // If the value at index is already negative, we found a duplicate
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                // Mark this number as seen by negating the value at index
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}
