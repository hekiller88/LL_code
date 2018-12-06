//https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/description

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

//Method 1: record path and then find LCA
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null)
            return null;
            
        List<TreeNode> path_A = helper(root, A);
        List<TreeNode> path_B = helper(root, B);
        
        int pA = path_A.size() - 1;
        int pB = path_B.size() - 1;
        
        while (pA >= 0 && pB >= 0) {
            if (path_A.get(pA) != path_B.get(pB))
                break;
                
            pA--; 
            pB--;
        }
        
        return path_A.get(pA + 1);
    }
    
    private List<TreeNode> helper(TreeNode node, TreeNode target) {
        List<TreeNode> result = new ArrayList<>();
        if (node == null)
            return result;
            
        List<TreeNode> left = helper(node.left, target);
        List<TreeNode> right = helper(node.right, target);
        
        result.addAll(left);
        result.addAll(right);
        
        if (result.size() != 0 || node == target) {
            result.add(node);
        }
        
        return result;
    }
}



//Method 2: Divide & Conquer
//3 cases: 1. if target in one of the subtree(left | right), return that subtree
//         2. if 2 target in each of the subtree, return the root
//         3. otherwise, return null
//base case: return A, B
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B)
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null)
            return root;
            
        if (left != null)
            return left;
        
        if (right != null)
            return right;
            
        return null;
    }
}
