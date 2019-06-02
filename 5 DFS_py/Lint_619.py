"""
Definition for a multi tree node.
class MultiTreeNode(object):
    def __init__(self, x):
        self.val = x
        children = [] # children is a list of MultiTreeNode
"""


class Solution:
    # @param {MultiTreeNode} root the root of k-ary tree
    # @return {int} the length of the longest consecutive sequence path
    def longestConsecutive3(self, root):
        up, down, max_len = self.helper(root)
        return max_len
    
    def helper(self, root):
        if root is None:
            return 0, 0, 0
        
        up_lst, down_lst, max_len_lst = [], [], []
        for c in root.children:
            c_up, c_down, c_max_len = self.helper(c)
            up_lst.append(c_up)
            down_lst.append(c_down)
            max_len_lst.append(c_max_len)
        
        up, down = 0, 0
        for i in range(len(root.children)):
            if root.val + 1 == root.children[i].val:
                down = max(down, down_lst[i] + 1)
            if root.val - 1 == root.children[i].val:
                up = max(up, up_lst[i] + 1)
        
        max_len = max(max_len_lst, default=0)
        max_len = max(down + up + 1, max_len)
        
        return up, down, max_len
