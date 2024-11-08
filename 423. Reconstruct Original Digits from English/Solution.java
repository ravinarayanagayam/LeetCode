class Solution {
    public String originalDigits(String s) {
        // Count occurrences of each letter in the input string
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Array to hold the count of each digit from 0 to 9
        int[] digits = new int[10];

        // Identify digits with unique letters
        digits[0] = count.getOrDefault('z', 0); // zero
        digits[2] = count.getOrDefault('w', 0); // two
        digits[4] = count.getOrDefault('u', 0); // four
        digits[6] = count.getOrDefault('x', 0); // six
        digits[8] = count.getOrDefault('g', 0); // eight

        // Identify digits using remaining letters after accounting for unique ones
        digits[3] = count.getOrDefault('h', 0) - digits[8]; // three
        digits[5] = count.getOrDefault('f', 0) - digits[4]; // five
        digits[7] = count.getOrDefault('s', 0) - digits[6]; // seven
        digits[1] = count.getOrDefault('o', 0) - digits[0] - digits[2] - digits[4]; // one
        digits[9] = count.getOrDefault('i', 0) - digits[5] - digits[6] - digits[8]; // nine

        // Build the output string based on the counts of each digit
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }
}
