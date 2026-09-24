class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Check first and last column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // Check first and last row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // Convert surrounded O -> X
        // Convert safe S -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        int m = board.length;
        int n = board[0].length;

        // Out of bounds
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        // Not an O
        if (board[row][col] != 'O') {
            return;
        }

        // Mark as safe
        board[row][col] = 'S';

        // Up
        dfs(board, row - 1, col);

        // Down
        dfs(board, row + 1, col);

        // Left
        dfs(board, row, col - 1);

        // Right
        dfs(board, row, col + 1);
    }
}