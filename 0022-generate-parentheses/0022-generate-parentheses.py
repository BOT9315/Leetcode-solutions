class Solution(object):
    def generateParenthesis(self, n):
        res = []

        def backtrack(path, open_count, close_count):
            if len(path) == 2 * n:
                res.append(path)
                return

            if open_count < n:
                backtrack(path + '(', open_count + 1, close_count)

            if close_count < open_count:
                backtrack(path + ')', open_count, close_count + 1)

        backtrack("", 0, 0)
        return res
