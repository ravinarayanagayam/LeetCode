class Solution {

    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        find(1, k, n, new LinkedList<Integer>());
        return result;
    }

    private void find(int start, int k, int n, LinkedList<Integer> r) {
        // System.out.print(start + ":" + k + ":" + n +":" + r);
        if (n == 0 && r.size() == k) {
            ArrayList<Integer> r1 = new ArrayList<Integer>();
            r1.addAll(r);
            result.add(r1);
            return;
        }

        if (n < 0)
            return;

        for (int i = start; i <= 9; i++) {
            r.addLast(i);
            find(i + 1, k, n - i, r);
            r.removeLast();
        }
    }
}