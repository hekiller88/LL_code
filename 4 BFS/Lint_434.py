# https://www.lintcode.com/problem/number-of-islands-ii/description?_from=ladder&&fromId=1

"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""

class Solution:
    """
    @param n: An integer
    @param m: An integer
    @param operators: an array of point
    @return: an integer array
    """
    def numIslands2(self, n, m, operators):
        if (not n 
            or not m 
            or not operators):
            return []
        
        oprs = [(pt.x, pt.y) for pt in operators]
        uf = UnionFind()
        
        ret = []
        for (x, y) in oprs:
            uf.add((x, y))
            
            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                new_x, new_y = x + dx, y + dy
                
                if (new_x, new_y) in uf.roots:
                    uf.union((x, y), (new_x, new_y))
            
            ret.append(uf.size)
            
        return ret
    
class UnionFind:
    def __init__(self):
        self.roots = {}
        self.size = 0
        
    def add(self, pt):
        if pt in self.roots:
            return
        
        self.roots[pt] = pt
        self.size += 1
        
    def find(self, pt):
        path = []
        while pt != self.roots[pt]:
            path.append(pt)
            pt = self.roots[pt]
            
        for p in path:
            self.roots[p] = pt
            
        return pt
        
    def union(self, u, v):
        root_u, root_v = self.find(u), self.find(v)
        if root_u != root_v:
            self.size -= 1
            self.roots[root_u] = root_v
        
