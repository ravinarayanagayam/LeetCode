class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort by height in descending order, and by k in ascending order if heights
        // are the same
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            return a[1] - b[1];
        });
        // for(int[] i:people) System.out.println(i[0]+":"+i[1]);
        List<int[]> result = new LinkedList<>();

        // Insert each person by their k value in the sorted list
        for (int[] person : people) {
            result.add(person[1], person); // Insert person at index k
        }

        // Convert the list back to a 2D array
        return result.toArray(new int[people.length][2]);
    }
}
