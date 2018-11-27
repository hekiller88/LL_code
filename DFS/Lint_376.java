// https://www.lintcode.com/problem/binary-tree-path-sum/description

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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)  
            return ret;
            
        helper(root, target, new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(TreeNode root, int remain, List<Integer> path, List<List<Integer>> ret) {
        if (root == null)
            return;
            
        path.add(root.val);
        remain -= root.val;
        
        if (root.left == null && root.right == null) {
            if (remain == 0) {
                ret.add(new ArrayList<>(path));
                //return; --> important, do not ret here, won't do backtrack
            }
        }
        
        helper(root.left, remain, path, ret);
        helper(root.right, remain, path, ret);
        
        System.out.println(path.toString());
        path.remove(path.size() - 1);
    }
}
