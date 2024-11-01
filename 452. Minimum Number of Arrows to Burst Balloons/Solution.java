class Solution {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        TreeMap<Integer, Integer> p = new TreeMap();
        for (int[] po : points) {
            if (p.containsKey(po[0])) {
                if (p.get(po[0]) > po[1])
                    p.put(po[0], po[1]);
            } else {
                p.put(po[0], po[1]);
            }
        }
        if (p.isEmpty())
            return 0;

        // System.out.print(p);
        Map.Entry<Integer, Integer> e = p.pollFirstEntry();
        result = 1;

        int start = e.getKey();
        int end = e.getValue();

        while (!p.isEmpty()) {
            e = p.pollFirstEntry();
            if (e.getKey() <= end) {
                start = e.getKey();
                if (e.getValue() <= end) {
                    end = e.getValue();
                }
            } else {
                result++;
                start = e.getKey();
                end = e.getValue();
            }
        }

        return result;
    }
}