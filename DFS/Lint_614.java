// https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii/description?_from=ladder&&fromId=1

// Thinking:
// record [increase, decrease] value for each node,
// which refer to the maximum inc or dec value from current node to below nodes
// by comparing whether the current node value is consecutive with its child node,
// update the child.inc + 1 or child.dec + 1 and pick the max inc and dec
// then the max length from current node = inc + dec - 1;

// M1, ResultType
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class ResultType {
        int maxLen, inr, dcr;
        public ResultType(int maxLen, int inr, int dcr) {
            this.maxLen = maxLen;
            this.inr = inr;
            this.dcr = dcr;
        }
    }
    public int longestConsecutive(TreeNode root) {
        return helper(root).maxLen;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null)
            return new ResultType(0, 0, 0);
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int inr = 1, dcr = 1; 
        if (root.left != null) {
            if (root.left.val + 1 == root.val) 
                inr = left.inr + 1;
            
            if (root.left.val - 1 == root.val)
                dcr = left.dcr + 1;
        }
        
        if (root.right != null) {
            if (root.right.val + 1 == root.val)
                inr = Math.max(inr, right.inr + 1);
            
            if (root.right.val - 1 == root.val)
                dcr = Math.max(dcr, right.dcr + 1);
        }
        
        int len = inr + dcr - 1;
        len = Math.max(len, Math.max(left.maxLen, right.maxLen));
        
        return new ResultType(len, inr, dcr);
    }
}
