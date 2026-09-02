class Solution:
    def solveNQueens(self, n):
        result = []
        board = [["."] * n for _ in range(n)]#for row and col create

        def is_safe(row, col):
            # check column
            for i in range(row):
                if board[i][col] == "Q":
                    return False

            # check left diagonal
            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j -= 1

            # check right diagonal
            i, j = row - 1, col + 1
            while i >= 0 and j < n:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j += 1

            return True

        def backtrack(row):
            if row == n:
                result.append(["".join(r) for r in board])
                return

            for col in range(n):
                if is_safe(row, col):
                    board[row][col] = "Q"
                    backtrack(row + 1)
                    board[row][col] = "."  # remove queen

        backtrack(0)
        return result