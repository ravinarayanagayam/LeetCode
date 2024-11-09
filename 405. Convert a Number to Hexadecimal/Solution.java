class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";

        // Characters representing hex digits
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();

        // Convert the number by taking 4 bits at a time
        while (num != 0 && result.length() < 8) { // Limit to 8 hex digits (32-bit number)
            int lastFourBits = num & 0xf; // Extract last 4 bits
            result.append(hexChars[lastFourBits]); // Map to hex character
            num >>>= 4; // Unsigned right shift by 4 bits
        }

        return result.reverse().toString(); // Reverse to get the correct hex order
    }
}
