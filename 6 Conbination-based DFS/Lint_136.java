// https://www.lintcode.com/problem/palindrome-partitioning/description

// M1, temp1
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ret;
        
        helper(s, 0, new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(String s,
                        int start,
                        List<String> partition,
                        List<List<String>> ret) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(partition));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!isPalindrome(sub))
                continue;
            partition.add(sub);
            helper(s, i + 1, partition, ret);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        
        return true;
    }
}

// M2-1, dp, simple ver
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ret;
            
        boolean[][] dp = getDP(s);
        
        helper(s, 0, dp, new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(String s,
                        int start,
                        boolean[][] dp,
                        List<String> partition,
                        List<List<String>> ret) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(partition));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                partition.add(s.substring(start, i + 1));
                helper(s, i + 1, dp, partition, ret);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    private boolean[][] getDP(String s) {
        int n = s.length();
        boolean[][] ret = new boolean[n][n];
        
        for (int c = 0; c < n; c++) 
            for (int r = 0; r <= c; r++) {
                ret[r][c] = s.charAt(r) == s.charAt(c) && (r + 1 >= c - 1 || ret[r + 1][c - 1]);
            }
            
        return ret;
    }
}

// M2-2, dp, more steps but easy to understand ver

private boolean[][] getDP(String s) {
        int n = s.length();
        boolean[][] ret = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            ret[i][i] = true;
            
            if (i + 1 < n) {
                ret[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        
        for (int r = n - 3; r >= 0; r--) 
            for (int c = r + 2; c < n; c++) {
                ret[r][c] = s.charAt(r) == s.charAt(c) && ret[r + 1][c - 1];
            }
            
        return ret;
    }
