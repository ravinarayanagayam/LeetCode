class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            minHeap.add(stone);

        while (minHeap.size() >= 2) {
            int x = minHeap.poll();
            int y = minHeap.poll();
            if (x == y)
                continue;
            y = Math.abs(x - y);
            minHeap.add(y);
        }
        if (minHeap.size() == 1)
            return minHeap.poll();
        return 0;
    }
}