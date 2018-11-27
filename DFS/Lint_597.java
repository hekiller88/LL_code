// https://www.lintcode.com/problem/subtree-with-maximum-average/description?_from=ladder&&fromId=1

// M1, personal ans, resultType
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    class ResultType {
        int cnt;
        double average;
        double maxAverage;
        TreeNode root;
        public ResultType(TreeNode root) {
            this.root = root;
            cnt = 0;
            average = 0.0;
            maxAverage = -Double.MAX_VALUE;
        }
    }
    public TreeNode findSubtree2(TreeNode root) {
        ResultType res = helper(root);
        
        return res.root;
    }
    
    private ResultType helper(TreeNode root) {
        ResultType res = new ResultType(root);
        if (root == null) 
            return res;
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        res.cnt = 1 + left.cnt + right.cnt;
        double sum = root.val + left.average * left.cnt + right.average * right.cnt;
        res.average = sum / res.cnt;
        res.maxAverage = res.average;
        
        if (left.maxAverage > res.maxAverage) {
            res.root = left.root;
            res.maxAverage = left.maxAverage;
        }
        
        if (right.maxAverage > res.maxAverage) {
            res.root = right.root;
            res.maxAverage = right.maxAverage;
        }
        
        return res;
    }
}
