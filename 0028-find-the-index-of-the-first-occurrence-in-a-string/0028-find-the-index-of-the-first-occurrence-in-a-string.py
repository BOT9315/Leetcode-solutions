class Solution:
    def strStr(self, haystack, needle):

        if needle == "":
            return 0

        n = len(haystack)
        m = len(needle)

        for i in range(n - m + 1):
            j = 0

            while j < m and haystack[i + j] == needle[j]:
                j += 1

            if j == m:
                return i

        return -1
