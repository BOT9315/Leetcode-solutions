class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0':
            return 0

        n = len(s)

        prev2 = 1  # dp[0]
        prev1 = 1  # dp[1]

        for i in range(2, n + 1):
            curr = 0

            # Single digit decode
            if s[i - 1] != '0':
                curr += prev1

            # Two digit decode
            two_digit = int(s[i - 2:i])

            if 10 <= two_digit <= 26:
                curr += prev2

            prev2 = prev1
            prev1 = curr

        return prev1