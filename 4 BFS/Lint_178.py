https://www.lintcode.com/problem/graph-valid-tree/description?_from=ladder&&fromId=1

# Method 1: BFS
class Solution:
    """
    @param n: An integer
    @param edges: a list of undirected edges
    @return: true if it's a valid tree, or false
    """
    def validTree(self, n, edges):
        if n == 0 or edges is None:
            return False
            
        if len(edges) != n - 1:
            return False
            
        graph = collections.defaultdict(set)
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)
            
        q = collections.deque([0])
        visited = set([0])
        while q:
            node = q.popleft()
            for neighbor in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)
                            
        return len(visited) == n
