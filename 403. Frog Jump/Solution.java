class Solution {
    public boolean canCross(int[] stones) {
        int l = stones.length;
        if (l < 2)
            return true;
        if (stones[1] != 1)
            return false;
        HashMap<Integer, Integer> lookUp = new HashMap();
        HashMap<Integer, HashSet<Integer>> dp = new HashMap();
        for (int i = 0; i < l; i++) {
            lookUp.put(stones[i], i);
            dp.put(i, new HashSet());
        }
        dp.get(1).add(1);

        for (int i = 1; i < l; i++) {
            for (int x : dp.get(i)) {
                int k = x - 1;
                if (k > 0) {
                    if (lookUp.containsKey(stones[i] + k)) {
                        int index = lookUp.get(stones[i] + k);
                        dp.get(index).add(k);
                    }
                }
                k = x;
                if (k > 0) {
                    if (lookUp.containsKey(stones[i] + k)) {
                        int index = lookUp.get(stones[i] + k);
                        dp.get(index).add(k);
                    }
                }
                k = x + 1;
                if (k > 0) {
                    if (lookUp.containsKey(stones[i] + k)) {
                        int index = lookUp.get(stones[i] + k);
                        dp.get(index).add(k);
                    }
                }
            }
        }

        if (!dp.get(l - 1).isEmpty())
            return true;

        return false;
    }
}