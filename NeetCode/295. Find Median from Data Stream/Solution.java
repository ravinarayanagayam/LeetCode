class MedianFinder {
    private PriorityQueue<Integer> low; // Max-heap
    private PriorityQueue<Integer> high; // Min-heap

    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        high = new PriorityQueue<>(); // Min-heap
    }

    public void addNum(int num) {
        // Add to max-heap
        low.offer(num);
        // Balance: move the largest from low to high
        high.offer(low.poll());
        // Ensure low has at least as many elements as high
        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */