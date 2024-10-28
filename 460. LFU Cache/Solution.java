class LFUCache {
    int capacity = 0;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Integer> counters;
    TreeMap<Integer, LinkedList<Integer>> reverseCounters;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap(capacity);
        counters = new HashMap(capacity);
        reverseCounters = new TreeMap(Collections.reverseOrder());
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int c = counters.get(key);
            reverseCounters.get(c).remove(Integer.valueOf(key));
            if (reverseCounters.get(c).size() == 0)
                reverseCounters.remove(c);
            LinkedList<Integer> l = reverseCounters.getOrDefault(c + 1, new LinkedList<Integer>());
            l.addFirst(key);
            reverseCounters.put(c + 1, l);
            counters.put(key, c + 1);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            int c = counters.get(key);
            reverseCounters.get(c).remove(Integer.valueOf(key));
            if (reverseCounters.get(c).size() == 0)
                reverseCounters.remove(c);
            LinkedList<Integer> l = reverseCounters.getOrDefault(c + 1, new LinkedList<Integer>());
            l.addFirst(key);
            reverseCounters.put(c + 1, l);
            counters.put(key, c + 1);
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                int lastCounter = reverseCounters.lastKey();
                LinkedList<Integer> l = reverseCounters.get(lastCounter);
                int key1 = l.removeLast();
                if (l.size() == 0) {
                    reverseCounters.remove(lastCounter);
                }
                counters.remove(key1);
                cache.remove(key1);
            }
            cache.put(key, value);
            counters.put(key, 1);
            LinkedList<Integer> l = reverseCounters.getOrDefault(1, new LinkedList<Integer>());
            l.addFirst(key);
            reverseCounters.put(1, l);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */