class Solution(object):
    def spiralOrder(self, matrix):
        res = []
        
        while matrix:
            res += matrix.pop(0)        # top row
            
            if matrix and matrix[0]:
                for row in matrix:
                    res.append(row.pop())   # right column
            
            if matrix:
                res += matrix.pop()[::-1]   # bottom row
            
            if matrix and matrix[0]:
                for row in matrix[::-1]:
                    res.append(row.pop(0))  # left column
        
        return res