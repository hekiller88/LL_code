// https://www.lintcode.com/problem/remove-node-in-binary-search-tree/description


// M1: D&C , simplified ver
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null)
            return null;
        
        if (value < root.val) {
            root.left = removeNode(root.left, value);
        } else if (value > root.val) {
            root.right = removeNode(root.right, value);
        } else {
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;
                
            root.val = findMax(root.left);
            root.left = removeNode(root.left, root.val);
        }
        
        return root;
    }
    
    private int findMax(TreeNode root) {
        if (root.right == null)
            return root.val;
        
        return findMax(root.right);
    }
}

// M2: D&V, full situations ver
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null)
            return root;
            
        if (value < root.val) {
            root.left = removeNode(root.left, value);
        } else if (value > root.val) {
            root.right = removeNode(root.right, value);
        } else {
            if (root.left == null && root.right == null)
                return null;
            
            if (root.left == null)
                return root.right;
                
            if (root.right == null)
                return root.left;
                
            //swap with max node in left subtree
            TreeNode curt = root.left;
            TreeNode pre = root;
            while (curt.right != null) {
                pre = root;
                curt = curt.right;
            }
            
            root.val = curt.val;
            if (pre.left == curt) pre.left = null;
            if (pre.right == curt) pre.right = null;
        }
        
        return root;
    }
