class Solution:
    def setZeroes(self, matrix):
        if not matrix or not matrix[0]:
            return
        
        rows, cols = len(matrix), len(matrix[0])
        col0 = 1
        
        # First pass: mark using first row/column
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    if j == 0:
                        col0 = 0
                    else:
                        matrix[0][j] = 0
                    matrix[i][0] = 0
        
        # Second pass: zero inner matrix
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
        
        # Handle first row
        if matrix[0][0] == 0:
            for j in range(cols):
                matrix[0][j] = 0
        
        # Handle first column
        if col0 == 0:
            for i in range(rows):
                matrix[i][0] = 0