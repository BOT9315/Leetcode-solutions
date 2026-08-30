class Solution(object):
    def isValid(self, s):
        stack = []
        match = {')': '(', '}': '{', ']': '['}

        for ch in s:
            if ch in match:
                if not stack or stack.pop() != match[ch]:
                    return False
            else:
                stack.append(ch)

        return not stack
