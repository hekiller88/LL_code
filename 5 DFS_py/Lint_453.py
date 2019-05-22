# iterative traversal
class Solution:
    """
    @param root: a TreeNode, the root of the binary tree
    @return: nothing
    """
    def flatten(self, root):
        if root is None:
            return
        
        stack = [root]
        curt = None
        pre = None
        
        while stack:
            curt = stack.pop()
            
            if pre:
                pre.left = None
                pre.right = curt
            
            pre = curt
            
            if curt.right:
                stack.append(curt.right)
                
            if curt.left:
                stack.append(curt.left)
            
