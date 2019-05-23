
# 1. my method, simplified path version
class Solution:
    """
    @param: root: The root of the tree
    @param: A: node in the tree
    @param: B: node in the tree
    @return: The lowest common ancestor of A and B
    """
    def lowestCommonAncestorII(self, root, A, B):
        if root is None:
            return None
            
        pathA = []
        while A:
            pathA.append(A)
            A = A.parent
            
        while B:
            if B in pathA:
                return B
            B = B.parent
        
        return None
        
# 2. recycle racing pointer to find intersection
class Solution:
    """
    @param: root: The root of the tree
    @param: A: node in the tree
    @param: B: node in the tree
    @return: The lowest common ancestor of A and B
    """
    def lowestCommonAncestorII(self, root, A, B):
        pA, pB = A, B
        
        while pA != pB:
            pA = pA.parent if pA.parent else B
            pB = pB.parent if pB.parent else A
        
        return pA
