class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

        for (char c : chars) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        TreeMap<Integer, HashSet<Character>> freqMap = new TreeMap(Collections.reverseOrder());

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            freqMap.put(entry.getValue(), freqMap.getOrDefault(entry.getValue(), new HashSet<Character>()));
            freqMap.get(entry.getValue()).add(entry.getKey());
        }

        StringBuilder result = new StringBuilder();
        while (!freqMap.isEmpty()) {
            Map.Entry<Integer, HashSet<Character>> entry = freqMap.pollFirstEntry();
            for (Character c : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}