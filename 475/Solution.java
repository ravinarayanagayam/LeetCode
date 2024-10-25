class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : heaters)
            pq.add(i);

        Arrays.sort(houses);

        int x = pq.poll();

        int result = 0;

        for (int i : houses) {
            if (i <= x || pq.size() == 0) {
                result = Math.max(result, Math.abs(x - i));
            } else {
                while (pq.size() > 0) {
                    int y = pq.peek();
                    if (y - i <= i - x) {
                        x = pq.poll();
                    } else {
                        break;
                    }
                }
                result = Math.max(result, Math.abs(i - x));
            }
        }

        return result;

    }
}