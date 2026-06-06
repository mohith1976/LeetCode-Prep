class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] represents if the 1st i characters in s match the 1st j chars in p
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string and empty pattern match
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* matching an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                // Case 1: Characters match directly or pattern has '.'
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // Case 2: Pattern has '*'
                else if (pc == '*') {
                    char pPrev = p.charAt(j - 2);
                    
                    // Option A: Zero occurrences of the preceding character
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } 
                    // Option B: One or more occurrences (if the preceding character matches)
                    else if (pPrev == '.' || pPrev == sc) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}