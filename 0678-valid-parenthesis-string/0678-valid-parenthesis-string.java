class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;  // '*' acts as ')'
                maxOpen++;  // '*' acts as '('
            }

            // Even the maximum possible opens became negative
            if (maxOpen < 0) {
                return false;
            }

            // Minimum cannot be negative
            minOpen = Math.max(minOpen, 0);
        }

        // We need at least one possibility with 0 open brackets
        return minOpen == 0;
    }
}