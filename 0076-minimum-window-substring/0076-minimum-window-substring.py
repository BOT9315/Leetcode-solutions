class Solution:
    def minWindow(self, s, t):
        from collections import Counter
        
        need = Counter(t)
        window = {}
        
        have = 0
        need_count = len(need)
        
        res = ""
        res_len = float('inf')
        
        left = 0
        
        for right in range(len(s)):
            char = s[right]
            window[char] = window.get(char, 0) + 1
            
            if char in need and window[char] == need[char]:
                have += 1
            
            while have == need_count:
                # update answer
                if (right - left + 1) < res_len:
                    res = s[left:right+1]
                    res_len = right - left + 1
                
                # remove from left
                window[s[left]] -= 1
                if s[left] in need and window[s[left]] < need[s[left]]:
                    have -= 1
                
                left += 1
        
        return res