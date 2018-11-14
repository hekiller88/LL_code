// https://www.lintcode.com/problem/lowest-common-ancestor-iii/description
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    boolean hasA = false, hasB = false;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode res = divConq(root, A, B);
        
        if (hasA && hasB)
            return res;
            
        return null;
    }
    
    private TreeNode divConq(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null ) {
            return root;
        }
        
        TreeNode left = divConq(root.left, A, B);
        TreeNode right = divConq(root.right, A, B);
        
        // you still need to dig down first 
        // beacuse one of A,B might not exist
        if (root == A || root == B) {
            hasA = root == A || hasA;
            hasB = root == B || hasB;
            return root;
        }
        
        if (left != null && right != null)
            return root;
            
        if (left != null)
            return left;
        
        if (right != null)
            return right;
        
        return null;
    }
}
