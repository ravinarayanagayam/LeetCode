class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + carry;
            result.append(sum % 10); // Append the last digit of the sum
            carry = sum / 10; // Update carry

            i--; // Move to the next digit
            j--;
        }

        return result.reverse().toString(); // Reverse the result to get the final answer
    }
}
