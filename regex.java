public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        // dp[i][j] = true if s[i:] matches p[j:].
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true; // empty s matches empty p

        // Handle patterns like "a*" or "a*b*" matching empty s
        for (int j = m - 1; j >= 0; j--) {
            if (j + 1 < m && p.charAt(j + 1) == '*') {
                dp[n][j] = dp[n][j + 2];
            } else {
                dp[n][j] = false;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                boolean firstMatch = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < m && p.charAt(j + 1) == '*') {
                    // Case 1: Treat '*' as zero occurrences → dp[i][j+2]
                    // Case 2: If firstMatch, consume one char of s and stay on same j → dp[i+1][j]
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
