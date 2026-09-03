class Solution:
    def uniquePaths(self, m, n):
        res = 1
        for i in range(1, min(m, n)):
            res = res * (m + n - 2 - i + 1) // i
        return res