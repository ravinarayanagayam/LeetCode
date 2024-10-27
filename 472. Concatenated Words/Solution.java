class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<Character, HashSet<String>> cache = new HashMap();
        ArrayList<String> result = new ArrayList<String>();
        for (String s : words) {
            Character c = s.charAt(0);
            HashSet<String> h = cache.getOrDefault(c, new HashSet<String>());
            h.add(s);
            cache.put(c, h);
        }
        for (String s : words) {
            LinkedList<String> checkAll = new LinkedList<String>();
            checkAll.add(s);
            boolean isReplaced = false;
            outer: while (!checkAll.isEmpty()) {
                String scheck = checkAll.removeFirst();
                Character c = scheck.charAt(0);
                if (cache.containsKey(c)) {
                    HashSet<String> h = cache.get(c);
                    for (String s1 : h) {
                        if (!s.equals(s1)) {
                            if (scheck.equals(s1)) {
                                isReplaced = true;
                                break outer;
                            }
                            if (scheck.startsWith(s1)) {
                                checkAll.add(scheck.replaceFirst(s1, ""));
                            }
                        }
                    }
                }
            }

            if (isReplaced)
                result.add(s);
        }

        return result;
    }
}