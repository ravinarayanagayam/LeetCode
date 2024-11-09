class Solution {
    public int strongPasswordChecker(String password) {
        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        int replace = 0, deleteCount = 0;

        // Step 1: Check character requirements
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                hasLower = true;
            else if (Character.isUpperCase(c))
                hasUpper = true;
            else if (Character.isDigit(c))
                hasDigit = true;
        }
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        // Step 2: Handle repeating characters
        int[] repeats = new int[length];
        for (int i = 0; i < length;) {
            int j = i;
            while (j < length && password.charAt(j) == password.charAt(i))
                j++;
            int repeatLen = j - i;
            if (repeatLen >= 3) {
                replace += repeatLen / 3;
                repeats[repeatLen % 3]++;
            }
            i = j;
        }

        // Step 3: Calculate steps based on length
        if (length < 6) {
            // Too short: Need to add characters
            return Math.max(missingTypes, 6 - length);
        } else if (length <= 20) {
            // Valid length: Fix repeats and missing types
            return Math.max(missingTypes, replace);
        } else {
            // Too long: Need to delete characters
            int overLength = length - 20;
            deleteCount = overLength;

            // Try to reduce replace count by deleting in repeat groups
            for (int i = 0; i < 3; i++) {
                if (overLength <= 0)
                    break;
                while (repeats[i] > 0 && overLength > 0) {
                    overLength -= i + 1;
                    replace--;
                    repeats[i]--;
                }
            }

            // Handle any remaining overlength deletions
            replace -= overLength / 3;
            return deleteCount + Math.max(missingTypes, replace);
        }
    }
}
