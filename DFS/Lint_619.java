// https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-iii/description?_from=ladder&&fromId=1

// M1, resultType
/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<MultiTreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    class ResultType {
        int maxLen, inc, dec;
        public ResultType (int maxLen, int inc, int dec) {
            this.maxLen = maxLen;
            this.inc = inc;
            this.dec = dec;
        }
    }
    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).maxLen;
    }
    
    private ResultType helper(MultiTreeNode root) {
        if (root == null)
            return new ResultType(0, 0, 0);
        
        int inc = 1, dec = 1, maxLen = 1;
        for (MultiTreeNode child: root.children) {
            ResultType res_child = helper(child);
            if (res_child.maxLen != 0) {
                if (child.val + 1 == root.val) 
                    inc = Math.max(inc, res_child.inc + 1);
                    
                if (child.val - 1 == root.val)
                    dec = Math.max(dec, res_child.dec + 1);
                    
                maxLen = Math.max(maxLen, res_child.maxLen);
            }
        }
        
        maxLen = Math.max(maxLen, inc + dec - 1);
        
        return new ResultType(maxLen, inc, dec);
    }
}
