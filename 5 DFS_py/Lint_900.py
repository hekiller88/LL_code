# M1, Binary Search Tree directly Traverse

class Solution:
    """
    @param root: the given BST
    @param target: the given target
    @return: the value in the BST that is closest to the target
    """
    def closestValue(self, root, target):
        if root is None:
            return None
        
        ans = float('inf')    
        while root:
            
            if abs(target - ans) > abs(target - root.val):
                ans = root.val
                
            root = root.left if target <= root.val else root.right
        
        return ans
