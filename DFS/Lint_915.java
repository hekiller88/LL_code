// https://www.lintcode.com/problem/inorder-predecessor-in-bst/description?_from=ladder&&fromId=1

// M1, (template)traversal
public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        TreeNode pred = null;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (curt == p && pred != null) {
                return pred;
            }
            pred = curt;
            curt = curt.right;
        }
        
        return null;
    }
}

// M2, over simplified
public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pred = null;
        
        while (root != null) {
            if (p.val > root.val) {
                pred = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        
        return pred;
    }
}
