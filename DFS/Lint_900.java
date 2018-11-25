// https://www.jiuzhang.com/solution/closest-binary-search-tree-value/#tag-other

// M1. simple ver
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int ans = root.val;
        
        while (root != null) {
            
            if (Math.abs(root.val - target) < Math.abs(ans - target)) {
                ans = root.val;
            }
            
            root = target <= root.val ? root.left : root.right;
        }
        
        return ans;
    }
}
