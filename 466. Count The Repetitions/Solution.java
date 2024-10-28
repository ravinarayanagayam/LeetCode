class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0)
            return 0;

        int len1 = s1.length(), len2 = s2.length();
        int[] repeatCount = new int[len2 + 1]; // number of s1 blocks used
        int[] nextIndex = new int[len2 + 1]; // index in s2

        int j = 0, count = 0; // j is the index for s2, count is how many times s2 is fully matched
        for (int i = 1; i <= n1; i++) {
            for (int k = 0; k < len1; k++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                    if (j == len2) {
                        j = 0;
                        count++;
                    }
                }
            }
            repeatCount[i] = count;
            nextIndex[i] = j;

            // Detecting a cycle
            for (int start = 0; start < i; start++) {
                if (nextIndex[start] == j) {
                    int prefixCount = repeatCount[start];
                    int patternCount = (repeatCount[i] - repeatCount[start]) * (n1 - start) / (i - start);
                    int suffixCount = repeatCount[start + (n1 - start) % (i - start)] - repeatCount[start];
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        return repeatCount[n1] / n2;
    }
}