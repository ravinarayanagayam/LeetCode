class Solution {
    public int compress(char[] chars) {

        if (chars.length <= 1)
            return chars.length;

        int totalLength = 0;
        int currentPointer = 0;
        char lastChar = chars[0];
        char previousChar = chars[0];
        int runningLength = 1;

        for (int i = 1; i < chars.length; i++) {
            previousChar = chars[i - 1];
            if (chars[i] != chars[i - 1]) {
                if (runningLength > 1) {
                    chars[currentPointer] = lastChar;
                    totalLength += 1;
                    lastChar = chars[i];
                    String s = "" + runningLength;
                    for (int j = 0; j < s.length(); j++) {
                        chars[currentPointer + 1 + j] = s.charAt(j);
                        totalLength += 1;
                    }
                    currentPointer = currentPointer + 1 + s.length();
                    runningLength = 1;
                } else {
                    chars[currentPointer] = lastChar;
                    lastChar = chars[i];
                    currentPointer += 1;
                    totalLength += 1;
                    runningLength = 1;
                }
            } else {
                runningLength++;
            }
        }
        if (previousChar != chars[chars.length - 1]) {
            chars[currentPointer] = lastChar;
            totalLength += 1;
        } else {
            chars[currentPointer] = lastChar;
            totalLength += 1;
            String s = "" + runningLength;
            for (int j = 0; j < s.length(); j++) {
                chars[currentPointer + 1 + j] = s.charAt(j);
                totalLength += 1;
            }
        }
        return totalLength;
    }
}