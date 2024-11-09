class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> lookUp = new HashSet();
        int result = 0;
        for (char c : s.toCharArray()) {
            if (lookUp.contains(c)) {
                result += 2;
                lookUp.remove(c);
                continue;
            }
            lookUp.add(c);
        }
        if (!lookUp.isEmpty())
            result++;
        return result;
    }
}