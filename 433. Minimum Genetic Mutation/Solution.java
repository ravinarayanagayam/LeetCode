class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        HashMap<String, ArrayList<String>> mapping = new HashMap();

        for (String s : bank) {
            ArrayList<String> map = new ArrayList<String>();
            for (int i = 0; i < bank.length; i++) {
                if (!s.equals(bank[i]) && diff(s, bank[i]) == 1) {
                    map.add(bank[i]);
                }
            }
            mapping.put(s, map);
        }
        String s = startGene;
        ArrayList<String> map = new ArrayList<String>();
        for (int i = 0; i < bank.length; i++) {
            if (!s.equals(bank[i]) && diff(s, bank[i]) == 1) {
                map.add(bank[i]);
            }
        }
        mapping.put(s, map);
        if (mapping.get(startGene).isEmpty())
            return -1;
        int result = 1;

        HashSet<String> visited = new HashSet<String>();
        TreeSet<String> currentLevel = new TreeSet<String>();
        TreeSet<String> nextLevel = new TreeSet<String>();
        currentLevel.add(startGene);

        System.out.println(mapping);

        while (!currentLevel.isEmpty()) {
            // System.out.println(currentLevel + " : " + nextLevel + " : " + visited);
            String c = currentLevel.pollFirst();
            visited.add(c);
            if (mapping.get(c).contains(endGene))
                break;
            for (String x : mapping.get(c))
                if (!visited.contains(x))
                    nextLevel.add(x);
            // System.out.println(currentLevel + " : " + nextLevel + " : " + visited);
            if (currentLevel.isEmpty()) {
                if (nextLevel.isEmpty())
                    return -1;
                currentLevel.addAll(nextLevel);
                nextLevel.clear();
                result++;
            }
        }

        return result;
    }

    private int diff(String first, String second) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (first.charAt(i) != second.charAt(i))
                diff++;
        }
        return diff;
    }
}