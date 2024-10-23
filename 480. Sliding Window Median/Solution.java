import java.util.*;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        // int[] slidingWindow = new int[k];
        ArrayList<Integer> slidingWindow = new ArrayList<>();

        for (int i = 0; i < k; i++)
            slidingWindow.add(nums[i]);

        Collections.sort(slidingWindow);

        // System.out.println(slidingWindow);

        int y = 0;
        if (k % 2 == 1) {
            result[y] = (slidingWindow.get(k / 2)) / 1.0d;
            y++;
        } else {
            result[y] = (slidingWindow.get(k / 2) / 2.0d + slidingWindow.get(k / 2 - 1) / 2.0d);
            y++;
        }

        for (int i = k; i < nums.length; i++) {
            int pos = Collections.binarySearch(slidingWindow, nums[i - k]);
            slidingWindow.remove(pos);
            int insertPos = Collections.binarySearch(slidingWindow, nums[i]);
            if (insertPos >= 0)
                slidingWindow.add(insertPos, nums[i]);
            else
                slidingWindow.add(-(insertPos + 1), nums[i]);

            // System.out.println(slidingWindow);

            if (k % 2 == 1) {
                result[y] = (slidingWindow.get(k / 2)) / 1.0d;
                y++;
            } else {
                result[y] = (slidingWindow.get(k / 2) / 2.0d + slidingWindow.get(k / 2 - 1) / 2.0d);
                y++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2147483647, 2147483647 };
        int k = 2;
        double[] d = new Solution().medianSlidingWindow(nums, k);
        for (double x : d)
            System.out.println(x);
    }
}