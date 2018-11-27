//https://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/description
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

//M1 - inorder + global pre node
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null)
            return;
            
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        
        pre = root;
        
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    
}

// M2: inorder + List<TreeNode>

// M3: Divide & Conquer
// Link Left Subtree's last Node with right Subtree root, 
// Link root.right with left root, clear root.left

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    //return last Node
    private TreeNode helper(TreeNode root) {
        if (root == null)
            return null;
            
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null)
            return rightLast;
            
        if (leftLast != null)
            return leftLast;
            
        return root;
    }
}
