//https://www.lintcode.com/problem/binary-tree-inorder-traversal/description

//M1, inorder recursive traverse

//M2, stack traverse, simple ver
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curt = root;
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        while (!stack.empty()) {
            curt = stack.pop();
            res.add(curt.val);
            
            if (curt.right != null) {
                curt = curt.right;
                
                while (curt != null) {
                    stack.push(curt);
                    curt = curt.left;
                }
            }
        }
        
        return res;
    }
}

//M3, stack traverse, complex ver
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curt = root;
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            res.add(node.val);
            
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return res;
    }
}
