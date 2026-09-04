class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean exponentDigitSeen = true;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (c >= '0' && c <= '9') {
                digitSeen = true;

                if (exponentSeen) {
                    exponentDigitSeen = true;
                }
            }

            // Dot
            else if (c == '.') {

                // Dot cannot come after exponent
                // and there can be only one dot
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {

                // Exponent needs a number before it
                // and only one exponent is allowed
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                exponentDigitSeen = false;
            }

            // + or -
            else if (c == '+' || c == '-') {

                // Sign is valid only at the beginning
                // or immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else is invalid
            else {
                return false;
            }
        }

        return digitSeen && exponentDigitSeen;
    }
}