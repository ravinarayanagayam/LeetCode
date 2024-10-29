class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            HashSet<Integer> hs = new HashSet();
            if ((i == (nums[i] + i) % l) && nums[i] + i >= l)
                continue;
            if ((i == ((((nums[j % l]) % l) + l) + i) % l) && nums[i] < 0)
                continue;
            if (nums[i] > 0) {
                while (true) {
                    if (nums[i] > 0 && nums[j % l] < 0)
                        break;
                    if (j > i && j % l == i)
                        return true;
                    if (hs.contains(j % l))
                        break;
                    hs.add(j % l);
                    j = j + nums[j % l];
                }
            } else {
                while (true) {
                    if (nums[i] < 0 && nums[j % l] > 0)
                        break;
                    if (j > i && j % l == i)
                        return true;
                    if (hs.contains(j % l))
                        break;
                    hs.add(j % l);
                    j = j + (((nums[j % l]) % l) + l);
                }
            }
        }
        return false;
    }
}