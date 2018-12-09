// https://www.lintcode.com/problem/palindrome-partitioning-ii/description

// M1, dp (isPalin[n][n] + cut[n])
public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
            
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];
        for (int c = 0; c < n; c++) {
            cut[c] = c;
            for (int r = 0; r <= c; r++) {
                if (s.charAt(r) == s.charAt(c) && ( r + 1 > c - 1 || dp[r + 1][c - 1])) {
                    dp[r][c] = true;
                    cut[c] = r == 0 ? 0 : Math.min(cut[c], cut[r - 1] + 1);
                }
            }
        }
            
        return cut[n - 1];
    }
}
