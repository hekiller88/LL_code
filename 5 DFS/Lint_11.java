// https://www.lintcode.com/problem/search-range-in-binary-search-tree/description

// M1: normal traverse
public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper(root, k1, k2, res);
        
        return res;
    }
    
    private void helper(TreeNode root, int k1, int k2, List<Integer> res) {
        if (root == null)
            return;
            
        if (root.val > k1) 
            helper(root.left, k1, k2, res);
        
        if (root.val >= k1 && root.val <= k2)
            res.add(root.val);
            
        if (root.val < k2)
            helper(root.right, k1, k2, res);
    }
}
