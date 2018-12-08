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
