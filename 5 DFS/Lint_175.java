// https://www.lintcode.com/problem/invert-binary-tree/description

// M1, traversal without recursive
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            
            TreeNode tmp = curt.left;
            curt.left = curt.right;
            curt.right = tmp;
            
            curt = curt.left;
        }
    }
}

// M2, recursive
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null)
            return;
            
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
