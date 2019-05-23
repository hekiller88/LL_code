#1. Elegant Way
class Solution:
    """
    @param: root: The root of the binary search tree.
    @param: A: A TreeNode in a Binary.
    @param: B: A TreeNode in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """
    def lowestCommonAncestor(self, root, A, B):
        if root is None or root == A or root == B:
            return root
            
        left = self.lowestCommonAncestor(root.left, A, B)
        right = self.lowestCommonAncestor(root.right, A, B)
        
        if left and right:
            return root
            
        if left:
            return left
            
        if right:
            return right
            
        return None

#2. My Way
class Solution:
    """
    @param: root: The root of the binary search tree.
    @param: A: A TreeNode in a Binary.
    @param: B: A TreeNode in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """
    def lowestCommonAncestor(self, root, A, B):
        if not root:
            return None
            
        self.ans = root
        
        self.helper(root, A, B)
        
        return self.ans
        
    def helper(self, node, A, B):
        if node is None:
            return False, False
            
        l_hasA, l_hasB = self.helper(node.left, A, B)
        r_hasA, r_hasB = self.helper(node.right, A, B)
        
        hasA = (node == A or l_hasA or r_hasA)
        hasB = (node == B or l_hasB or r_hasB)
        
        if hasA and hasB:
            self.ans = node
            return False, False
        
        return hasA, hasB
