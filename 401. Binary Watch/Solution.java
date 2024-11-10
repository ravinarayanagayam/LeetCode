class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Edge case: if turnedOn is greater than 8, return an empty list
        if (turnedOn > 8)
            return result;

        // Loop through all possible hours (0 to 11) and minutes (0 to 59)
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of "1"s in the binary representation of hour and minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Format minute to always be two digits
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }
}
