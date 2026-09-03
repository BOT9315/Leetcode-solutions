class Solution:
    def getPermutation(self, n, k):
        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i
        digits = list(range(1, n + 1))
        k -= 1
        result = []
        for i in range(n, 0, -1):
            idx = k // fact[i - 1]
            result.append(str(digits[idx]))
            digits.pop(idx)
            k %= fact[i - 1]
        return "".join(result)