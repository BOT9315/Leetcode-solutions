class Solution {
public:

    bool isPalindrome(string s, int left, int right) {

        while (left < right) {

            if (s[left] != s[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    void backtrack(string s, int start,
                   vector<string>& current,
                   vector<vector<string>>& ans) {

        // Reached the end
        if (start == s.length()) {
            ans.push_back(current);
            return;
        }

        // Try all possible substrings
        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                string part = s.substr(start, end - start + 1);

                current.push_back(part);

                backtrack(s, end + 1, current, ans);

                // Backtracking
                current.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {

        vector<vector<string>> ans;
        vector<string> current;

        backtrack(s, 0, current, ans);

        return ans;
    }
};