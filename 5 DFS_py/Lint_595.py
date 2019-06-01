class Solution:
    """
    @param root: the root of binary tree
    @return: the length of the longest consecutive sequence path
    """
    def longestConsecutive(self, root):
        _, max_len = self.helper(root)
        return max_len
    
    #return curt_len, max_len
    def helper(self, root):
        if root is None:
            return 0, 0
            
        l_curt_len, l_max_len = self.helper(root.left)
        r_curt_len, r_max_len = self.helper(root.right)
        
        c_curt_len = 1
        c_max_len = 0
        
        if root.left and root.val + 1 == root.left.val:
            c_curt_len = max(c_curt_len, l_curt_len + 1)
        
        if root.right and root.val + 1 == root.right.val:
            c_curt_len = max(c_curt_len, r_curt_len + 1)
        
        c_max_len = max(c_curt_len, l_max_len, r_max_len)
        
        return c_curt_len, c_max_len
