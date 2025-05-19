class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, LinkedList<int[]>> p = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue(Collections.reverseOrder());

        for (int[] point : points) {
            int d = point[0] * point[0] + point[1] * point[1];
            minHeap.add(d);
            LinkedList<int[]> l = p.getOrDefault(d, new LinkedList<int[]>());
            l.add(point);
            p.put(d, l);
            if (minHeap.size() > k) {
                d = minHeap.poll();
                p.get(d).removeFirst();
            }
        }
        // System.out.println(minHeap + " "+p);
        int[][] result = new int[k][2];
        int j = 0;
        while (!minHeap.isEmpty()) {
            int i = minHeap.poll();
            result[j++] = p.get(i).removeFirst();
        }
        return result;
    }
}