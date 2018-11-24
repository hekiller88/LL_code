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
        // write your code here
        if(root == null){
            return null;
        }
        
        if(root.val == value){
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left != null && root.right != null){
                int maxLeft = findMax(root.left);
                root.val = maxLeft;
                root.left = removeNode(root.left, maxLeft);
            }else if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root = root.left;
            }
        }else if(root.val > value){
            root.left = removeNode(root.left, value);
        }else{
            root.right = removeNode(root.right, value);
        }
        return root;
    }
    
    private int findMax(TreeNode root){
        if(root.right == null){
            return root.val;
        }
        return findMax(root.right);
    }
}
