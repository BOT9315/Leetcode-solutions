import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // Empty string can always be formed
        dp[0] = true;
        for (int i=1;i<=n;i++) {
            for (String word : wordDict) {
                int len = word.length();
                // Check if word can fit before position i
                if (i>=len && dp[i - len]) {
                    String part = s.substring(i - len, i);
                    if (part.equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}