import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // [char index, frequency]
                if (freq[i] > (s.length() + 1) / 2)
                    return ""; // impossible case
                maxHeap.offer(new int[] { i, freq[i] });
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = { -1, 0 }; // previous character and frequency

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.append((char) (curr[0] + 'a'));
            curr[1]--;

            if (prev[1] > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
        }

        return result.toString();
    }
}
