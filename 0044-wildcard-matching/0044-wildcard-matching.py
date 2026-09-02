class Solution:
    def isMatch(self, s, p):
        m, n = len(s), len(p)
        dp = [[False]*(n+1) for _ in range(m+1)]
        dp[0][0] = True
        
        for j in range(n):
            if p[j] == '*':
                dp[0][j+1] = dp[0][j]
        
        for i in range(m):
            for j in range(n):
                if p[j] == s[i] or p[j] == '?':
                    dp[i+1][j+1] = dp[i][j]
                elif p[j] == '*':
                    dp[i+1][j+1] = dp[i+1][j] or dp[i][j+1]
        
        return dp[m][n]