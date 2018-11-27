// https://www.lintcode.com/problem/binary-tree-paths/description


// M1, d & c, sons build father
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
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
     
    private int lvl = 0;
    
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
            
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        if (left.isEmpty() && right.isEmpty()) {
            result.add(root.val + "");
            return result;
        }
        
        for (String path: left) {
            result.add(root.val + "->" + path);
        }
    
        for (String path: right) {
            result.add(root.val + "->" + path);
        }
        
        return result;
        
    }
}

// M2 , backtrack traversal, find leaf(final sons) build ret
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> ret = new ArrayList<>();
        if (root == null)
            return ret;
            
        helper(root, new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(TreeNode root, List<TreeNode> path, List<String> ret) {
        if (root == null)
            return;
            
        path.add(root);
        
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0).val);
            for (int i = 1; i < path.size(); i++) {
                sb.append("->" + path.get(i).val);
            }
            ret.add(sb.toString());
        }
        
        helper(root.left, path, ret);
        helper(root.right, path, ret);
        
        path.remove(path.size() - 1);
    }
}
