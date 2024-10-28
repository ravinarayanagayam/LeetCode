class LFUCache {
    private final int capacity;
    private int minFreq;
    private final HashMap<Integer, Integer> keyToValue;
    private final HashMap<Integer, Integer> keyToFreq;
    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        int value = keyToValue.get(key);
        increaseFrequency(key);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFrequency(key);
            return;
        }

        if (keyToValue.size() == capacity) {
            evictLFU();
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void increaseFrequency(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }

        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFU() {
        int keyToEvict = freqToKeys.get(minFreq).iterator().next();
        freqToKeys.get(minFreq).remove(keyToEvict);
        if (freqToKeys.get(minFreq).isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(keyToEvict);
        keyToFreq.remove(keyToEvict);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1); // cache=[1,_], cnt(1)=1
        lfu.put(2, 2); // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1)); // returns 1
        lfu.put(3, 3); // 2 is LFU, evict 2, cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2)); // returns -1 (not found)
        System.out.println(lfu.get(3)); // returns 3
        lfu.put(4, 4); // 1 and 3 have the same cnt, evict 1 (LRU), cache=[4,3]
        System.out.println(lfu.get(1)); // returns -1 (not found)
        System.out.println(lfu.get(3)); // returns 3
        System.out.println(lfu.get(4)); // returns 4
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */