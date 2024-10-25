import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Sort both arrays
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;

        // For each house, find the minimum distance to the nearest heater
        for (int house : houses) {
            // Binary search to find the closest heater for the current house
            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                // If the house is not found in heaters array, find the nearest heaters
                index = -(index + 1);

                int leftHeaterDistance = (index - 1 >= 0) ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int rightHeaterDistance = (index < heaters.length) ? heaters[index] - house : Integer.MAX_VALUE;

                // Take the minimum distance from either the left or right heater
                int closestDistance = Math.min(leftHeaterDistance, rightHeaterDistance);

                // Update the maximum radius required
                radius = Math.max(radius, closestDistance);
            }
        }

        return radius;
    }
}
