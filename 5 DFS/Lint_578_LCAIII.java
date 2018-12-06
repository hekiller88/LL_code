// https://www.lintcode.com/problem/lowest-common-ancestor-iii/description
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

//Method 1: global var
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    boolean hasA = false, hasB = false;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode res = divConq(root, A, B);
        
        if (hasA && hasB)
            return res;
            
        return null;
    }
    
    private TreeNode divConq(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null ) {
            return root;
        }
        
        TreeNode left = divConq(root.left, A, B);
        TreeNode right = divConq(root.right, A, B);
        
        // you still need to dig down first 
        // beacuse one of A,B might not exist
        if (root == A || root == B) {
            hasA = root == A || hasA;
            hasB = root == B || hasB;
            return root;
        }
        
        if (left != null && right != null)
            return root;
            
        if (left != null)
            return left;
        
        if (right != null)
            return right;
        
        return null;
    }
}

// M3, personal brutal, list 2 paths,
// notice: special case {1}, 1, 1
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    boolean hasA = false;
    boolean hasB = false;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        
        if (root == A && root == B)
            return root;
        
        List<List<TreeNode>> ret = new ArrayList<>();
        helper(root, A, B, new ArrayList<>(), ret);
        
        if (ret.size() != 2)
            return null;
            
        int idx = 0;
        int minLen = Math.min(ret.get(0).size(), ret.get(1).size());
        
        while (idx < minLen && ret.get(0).get(idx) == ret.get(1).get(idx)) {
            idx++;
        }
        
        return ret.get(0).get(idx - 1);
    }
    
    private void helper(TreeNode root, 
                        TreeNode A, 
                        TreeNode B, 
                        List<TreeNode> path,
                        List<List<TreeNode>> ret) {
        if (root == null)
            return; 
        
        path.add(root);
        
        if (root == A || root == B) {
            ret.add(new ArrayList<>(path));
        }
            
        helper(root.left, A, B, path, ret);
        helper(root.right, A, B, path, ret);
        
        path.remove(path.size() - 1);
    }
}

//M3: res_type
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    class ResultType {
        boolean hasA, hasB;
        TreeNode node;
        
        ResultType (boolean a, boolean b, TreeNode n) {
            hasA = a;
            hasB = b;
            node = n;
        }
    }
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType res = helper(root, A, B);
        
        if (res.hasA && res.hasB)
            return res.node;
            
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return new ResultType(false, false, null);
            
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean hasA = left.hasA || right.hasA || root == A;
        boolean hasB = left.hasB || right.hasB || root == B;
        
        if (root == A || root == B) 
            return new ResultType(hasA, hasB, root);
            
        if (left.node != null && right.node != null)
            return new ResultType(hasA, hasB, root);
        
        if (left.node != null)
            return new ResultType(hasA, hasB, left.node);
            
        if (right.node != null)
            return new ResultType(hasA, hasB, right.node);
            
        return new ResultType(hasA, hasB, null);
    }
}
