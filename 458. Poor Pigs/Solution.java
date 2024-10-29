public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest / minutesToDie + 1;
        int pigs = 0;

        while (Math.pow(rounds, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.poorPigs(4, 15, 15)); // Output: 2
        System.out.println(solution.poorPigs(4, 15, 30)); // Output: 2
        System.out.println(solution.poorPigs(1000, 15, 60)); // Output: 5
    }
}
