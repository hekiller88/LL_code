//https://www.lintcode.com/problem/wildcard-matching/description

//M1, DP
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        
        //clean continues *
        //a***b**c -> a*b*c
        int len_cleaned = clean(p_arr);
        
        //initialize
        boolean[][] dp = new boolean[s_arr.length + 1][len_cleaned + 1];
        dp[0][0] = true;
        if (len_cleaned > 0 && p_arr[0] == '*')
            dp[0][1] = true;
    
        System.out.println();
        for (int i = 1; i < dp.length; i++) 
            for (int j = 1; j < dp[0].length; j++) {
            if (s_arr[i - 1] == p_arr[j - 1] || p_arr[j - 1] == '?')
                dp[i][j] = dp[i - 1][j - 1];
            
            if (p_arr[j - 1] == '*')
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    
        }
        
        return dp[s_arr.length][len_cleaned];
        
    }

    //return the length of cleaned arr
    private int clean(char[] arr) {
        boolean isFirst = true;
        int writeIdx = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*' && isFirst) {
                isFirst = false;
                arr[writeIdx++] = '*';
            } else {
                isFirst = true;
                arr[writeIdx++] = arr[i]; 
            }
        }
        
        return writeIdx;
    }
}
