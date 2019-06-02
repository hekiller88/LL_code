"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root of binary tree
    @return: the length of the longest consecutive sequence path
    """
    def longestConsecutive2(self, root):
        up, down, max_len = self.helper(root)
        return max_len
        
    def helper(self, root):
        if root is None:
            return 0, 0, 0
            
        l_up, l_down, l_max_len = self.helper(root.left)
        r_up, r_down, r_max_len = self.helper(root.right)
        
        down, up = 0, 0
        
        if root.left:
            if root.val + 1 == root.left.val:
                down = max(down, l_down + 1)
            if root.val - 1 == root.left.val:
                up = max(up, l_up + 1)
                
        if root.right:
            if root.val + 1 == root.right.val:
                down = max(down, r_down + 1)
            if root.val - 1 == root.right.val:
                up = max(up, r_up + 1)
                
        max_len = max(1 + down + up, l_max_len, r_max_len)
        
        return up, down, max_len
        
            
        
