// https://www.lintcode.com/problem/kth-smallest-element-in-a-bst/description

// M1, traversal 
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
     
    int remain, ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        remain = k;        
        helper(root);        
        return ans;
        
    }
    
    private void helper(TreeNode root) {
        if (root == null)
            return;
        
        helper(root.left);
        
        remain--;
        if (remain == 0) {
            ans = root.val;
            return;
        }
        
        helper(root.right);        
    }
}

// M2 Follow Up, count + quickSelect
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        
        int left = nodeCount(root.left);
        
        if (left + 1 > k) {
            return kthSmallest(root.left, k);
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return root.val;
        }
        
    }
    
    private int nodeCount(TreeNode root) {
        if (root == null)
            return 0;
            
        int left = nodeCount(root.left);
        int right = nodeCount(root.right);
        
        return left + right + 1;
    }
}
