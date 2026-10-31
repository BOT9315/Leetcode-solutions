
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening brackets
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else {
                // If stack is empty
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check matching brackets
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // All brackets must be matched
        return st.isEmpty();
    }
}
