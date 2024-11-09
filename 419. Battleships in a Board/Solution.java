class Solution {
    public int countBattleships(char[][] board) {

        int result = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (valid(board, i, j, m, n)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean valid(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '1';
        while (i + 1 < m && board[i + 1][j] == 'X') {
            board[i + 1][j] = '1';
            i++;
        }
        while (j + 1 < n && board[i][j + 1] == 'X') {
            board[i][j + 1] = '1';
            j++;
        }
        return true;
    }
}