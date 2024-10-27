/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int index;
        while (true) {
            // Generate a number between 1 and 49
            int row = rand7();
            int col = rand7();
            index = (row - 1) * 7 + col;

            // If index is within 1 to 40, map it to 1 to 10
            if (index <= 40) {
                return (index - 1) % 10 + 1;
            }
            // Otherwise, repeat the process
        }
    }
}