class Solution {
    public int countBattleships(char[][] board) {

        int result = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' &&
                        (i == 0 || board[i - 1][j] != 'X') &&
                        (j == 0 || board[i][j - 1] != 'X')) {
                    result++;
                }
            }
        }
        return result;
    }
}