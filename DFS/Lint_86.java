// https://www.lintcode.com/problem/binary-search-tree-iterator/description

// M1, my ans, use stack traversal
public class BSTIterator {
    
    Stack<TreeNode> stack;
    /*
    * @param root: The root of binary tree.
    */public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curt = root;
        
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode res = null;
        if (hasNext()) {
            res = stack.pop();
            
            if (res.right != null) {
                TreeNode curt = res.right;
                while (curt != null) {
                    stack.push(curt);
                    curt = curt.left;
                }
            }
        }
        
        return res;
    }
}
