public class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character to the compressed array
            chars[write++] = currentChar;

            // If count > 1, write the count as well
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
