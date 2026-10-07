import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();

        // Find minimum number of '(' and ')' to remove
        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right, 0, new StringBuilder(), ans);

        return ans;
    }

    private void backtrack(
            String s,
            int index,
            int leftRemove,
            int rightRemove,
            int balance,
            StringBuilder current,
            List<String> ans) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {
            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                String result = current.toString();

                if (!ans.contains(result)) {
                    ans.add(result);
                }
            }
            return;
        }

        char ch = s.charAt(index);

        // Case 1: '('
        if (ch == '(') {

            // Remove '('
            if (leftRemove > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    current,
                    ans
                );
            }

            // Keep '('
            current.append(ch);

            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current,
                ans
            );

            current.deleteCharAt(current.length() - 1);
        }

        // Case 2: ')'
        else if (ch == ')') {

            // Remove ')'
            if (rightRemove > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    current,
                    ans
                );
            }

            // Keep ')' only if there is '(' available
            if (balance > 0) {
                current.append(ch);

                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current,
                    ans
                );

                current.deleteCharAt(current.length() - 1);
            }
        }

        // Case 3: letter
        else {
            current.append(ch);

            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current,
                ans
            );

            current.deleteCharAt(current.length() - 1);
        }
    }
}