class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> temps = new ArrayDeque();
        ArrayDeque<Integer> days = new ArrayDeque();
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!temps.isEmpty() && temps.peek() < temperatures[i]) {
                temps.pop();
                int pos = days.pop();
                result[pos] = i - pos;
            }
            temps.push(temperatures[i]);
            days.push(i);
            result[i] = 0;
        }

        return result;
    }
}