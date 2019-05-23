#1 My Ans, path template
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, A, B):
        if not root:
            return None
        
        pathA, pathB = [], []
        self.build_path(root, A, [], pathA)
        self.build_path(root, B, [], pathB)
        
        print([a.val for a in pathA])
        print([b.val for b in pathB])
        
        if not pathA or not pathB:
            return None
        
        lca = None
        for i in range(min(len(pathA), len(pathB))):
            if pathA[i] == pathB[i]:
                lca = pathA[i]
            
        return lca
            
    
    def build_path(self, node, target, path, ret):
        if node is None:
            return 
            
        path.append(node)
        
        if node == target:
            ret.extend(path)
        
        self.build_path(node.left, target, path, ret)
        self.build_path(node.right, target, path, ret)
        
        path.pop()
        
