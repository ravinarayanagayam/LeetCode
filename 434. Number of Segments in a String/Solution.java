class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int count = 1;
        char[] sc = s.toCharArray();
        for (int i = 1; i < sc.length; i++) {
            if (sc[i - 1] != ' ' && sc[i] == ' ')
                count++;
        }
        return count;
    }
}