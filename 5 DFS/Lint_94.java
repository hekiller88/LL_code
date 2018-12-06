// https://www.lintcode.com/problem/binary-tree-maximum-path-sum/description?_from=ladder&&fromId=1

// M1, resultType
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    
    class ResultType {
        int maxPath, maxLen;
        public ResultType(int maxPath, int maxLen) {
            this.maxPath = maxPath;
            this.maxLen = maxLen;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        return helper(root).maxLen;
    }
    
    private ResultType helper(TreeNode root) {
        ResultType res = new ResultType(0, Integer.MIN_VALUE);
        if (root == null)
            return res;
            
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int len = left.maxPath + right.maxPath + root.val;
        res.maxLen = Math.max(len, Math.max(left.maxLen, right.maxLen));
        res.maxPath = Math.max(0, Math.max(left.maxPath + root.val, right.maxPath + root.val));
        
        return res;
    }
}

// M2, global (leetcode over simple)
public class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    // helper returns the max branch 
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        max = Math.max(max, root.val + left + right);
        
        return root.val + Math.max(left, right);
    }
}
