// https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description?_from=ladder&&fromId=1

// M1 top-down w/ global var (more like mix, top-down + bottom-up)
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root, null, 0);
        
        return maxLen;
    }
    
    private void helper(TreeNode root, TreeNode parent, int len) {
        if (root == null)
            return;
        
        len = (parent != null && parent.val + 1 == root.val) ?
              len + 1 :
              1;
        maxLen = Math.max(len, maxLen);
        
        helper(root.left, root, len);
        helper(root.right, root, len);
        
    }
    
// M1 - 2: top-down without global var (more like mix, top-down + bottom-up)

public int longestConsecutive(TreeNode root) {
    return dfs(root, null, 0);
}

private int dfs(TreeNode p, TreeNode parent, int length) {
    if (p == null) return length;
    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
    return Math.max(length, Math.max(dfs(p.left, p, length),
                                     dfs(p.right, p, length)));
}

// M2, bottom-up
private int maxLength = 0;
public int longestConsecutive(TreeNode root) {
    dfs(root);
    return maxLength;
}

private int dfs(TreeNode p) {
    if (p == null) return 0;
    int L = dfs(p.left) + 1;
    int R = dfs(p.right) + 1;
    if (p.left != null && p.val + 1 != p.left.val) {
        L = 1;
    }
    if (p.right != null && p.val + 1 != p.right.val) {
        R = 1;
    }
    int length = Math.max(L, R);
    maxLength = Math.max(maxLength, length);
    return length;
}
