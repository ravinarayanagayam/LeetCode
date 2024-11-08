class AllOne {

    HashMap<String, Integer> strCount;
    HashMap<Integer, HashSet<String>> countStr;
    int maxKey = 0;
    int minKey = 0;

    public AllOne() {
        strCount = new HashMap();
        countStr = new HashMap();
    }

    public void inc(String key) {
        int c = strCount.getOrDefault(key, 0) + 1;
        strCount.put(key, c);
        HashSet<String> k = countStr.getOrDefault(c, new HashSet<String>());
        k.add(key);
        countStr.put(c, k);
        if (countStr.containsKey(c - 1)) {
            countStr.get(c - 1).remove(key);
            if (countStr.get(c - 1).isEmpty())
                countStr.remove(c - 1);
        }
        maxKey = Math.max(c, maxKey);
        minKey = Math.min(c, minKey);
        if (!countStr.containsKey(minKey))
            minKey = c;
        // System.out.println("INC: " + key + strCount+ " - " + countStr + " - " +
        // maxKey+ " - " + minKey);
    }

    public void dec(String key) {
        int c = strCount.getOrDefault(key, 0);
        if (c == 1)
            strCount.remove(key);
        else
            strCount.put(key, c - 1);
        if (c - 1 > 0) {
            HashSet<String> k = countStr.getOrDefault(c - 1, new HashSet<String>());
            k.add(key);
            countStr.put(c - 1, k);
            if (countStr.containsKey(c)) {
                countStr.get(c).remove(key);
                if (countStr.get(c).isEmpty())
                    countStr.remove(c);
            }
        } else {
            countStr.get(c).remove(key);
            if (countStr.get(c).isEmpty())
                countStr.remove(c);
        }
        if (!countStr.containsKey(maxKey))
            maxKey--;
        if (!countStr.containsKey(minKey))
            minKey--;
        if (minKey == 0 && countStr.size() > 0) {
            minKey = Collections.min(countStr.keySet());
        }
        // System.out.println("DEC: " + key +strCount+ " - " + countStr + " - " +
        // maxKey+ " - " + minKey);
    }

    public String getMaxKey() {
        if (maxKey == 0)
            return "";
        for (String s : countStr.get(maxKey))
            return s;
        return "";
    }

    public String getMinKey() {
        if (minKey == 0)
            return "";
        for (String s : countStr.get(minKey))
            return s;
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */