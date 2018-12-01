// https://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii/description?_from=ladder&&fromId=1

public class Solution {
    /**
     * @param root: the root of binary tree.
     * @return: An integer
     */
    
    public int maxPathSum2(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = Math.max(0, maxPathSum2(root.left));
        int right = Math.max(0, maxPathSum2(root.right));
        
        return Math.max(left, right) + root.val;
    }
}
