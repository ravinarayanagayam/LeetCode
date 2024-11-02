import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int boomerangs = 0;

        // Iterate over each point as the "base" point `i`
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> distanceCount = new HashMap<>();

            // Calculate distance from `i` to every other point `j`
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distanceSquared = dx * dx + dy * dy;

                // Update the count of points at this distance
                distanceCount.put(distanceSquared, distanceCount.getOrDefault(distanceSquared, 0) + 1);
            }

            // Calculate the number of boomerangs for each distance count
            for (int count : distanceCount.values()) {
                if (count >= 2) {
                    boomerangs += count * (count - 1);
                }
            }
        }

        return boomerangs;
    }
}
