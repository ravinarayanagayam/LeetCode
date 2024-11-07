class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pCount = new HashMap<Character, Integer>();
        for (char c : p.toCharArray())
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> runningCount = new HashMap<Character, Integer>();
        int lastStart = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pCount.containsKey(c)) {
                runningCount.put(c, runningCount.getOrDefault(c, 0) + 1);
                if (runningCount.get(c) > pCount.get(c)) {
                    while (s.charAt(lastStart) != c) {
                        char x = s.charAt(lastStart);
                        runningCount.put(x, runningCount.get(x) - 1);
                        if (runningCount.get(x) == 0)
                            runningCount.remove(x);
                        lastStart++;
                    }
                    char x = s.charAt(lastStart);
                    runningCount.put(x, runningCount.get(x) - 1);
                    if (runningCount.get(x) == 0)
                        runningCount.remove(x);
                    lastStart++;
                }
                if (runningCount.size() == pCount.size() && i - lastStart + 1 == p.length()) {
                    result.add(lastStart);
                    while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(lastStart)) {
                        i++;
                        lastStart++;
                        result.add(lastStart);
                    }
                }
            } else {
                lastStart = i + 1;
                runningCount.clear();
            }
        }
        return result;

    }
}