class Solution {
    public String reverseWords(String s) {
        
        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        StringBuilder ans = new StringBuilder();

        // Traverse from last word to first word
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}