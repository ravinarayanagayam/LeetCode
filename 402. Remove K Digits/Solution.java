class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0"; // If we need to remove all digits, return "0".

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // Remove last digit from the stack if it is greater than the current digit
            // and we still have digits to remove (k > 0).
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // If we still have digits to remove, remove them from the end of the result
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove any leading zeros
        while (stack.length() > 1 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        return stack.length() == 0 ? "0" : stack.toString();
    }
}
