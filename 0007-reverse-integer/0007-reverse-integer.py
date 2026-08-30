class Solution(object):
    def reverse(self, x):
        INT_MAX = 2147483647
        INT_MIN = -2147483648

        sign = -1 if x < 0 else 1
        x = abs(x)

        rev = 0
        while x != 0:
            digit = x % 10
            x //= 10

            # Overflow check
            if rev > INT_MAX // 10 or (rev == INT_MAX // 10 and digit > 7):
                return 0

            rev = rev * 10 + digit

        rev *= sign

        if rev < INT_MIN or rev > INT_MAX:
            return 0

        return rev
