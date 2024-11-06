class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        ArrayList<Integer> result = new ArrayList();

        HashSet<Integer> cache = new HashSet<Integer>();

        for (int i : nums) {
            if (cache.contains(i)) {
                result.add(i);
            }
            cache.add(i);
        }

        return result;

    }
}