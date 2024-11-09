class Solution {
    public int thirdMax(int[] nums) {

        TreeSet<Integer> c = new TreeSet<Integer>();

        for (int i : nums) {
            c.add(i);
            if (c.size() > 3) {
                c.pollFirst();
            }
        }
        if (c.size() < 3) {
            while (c.size() != 1) {
                c.pollFirst();
            }
        }
        return c.pollFirst();
    }
}