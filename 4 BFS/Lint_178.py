# https://www.lintcode.com/problem/graph-valid-tree/description?_from=ladder&&fromId=1

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

 # Method 2.1 elegant, pythonic UnionFind
class Solution:
    """
    @param n: An integer
    @param edges: a list of undirected edges
    @return: true if it's a valid tree, or false
    """
    def validTree(self, n, edges):
        if len(edges) != n - 1:
            return False
            
        parents = list(range(n)) # in python3
            
        def find(x):
            return x if x == parents[x] else find(parents[x])
            
        def union(edge):
            root_x, root_y = map(find, edge)
            parents[root_x] = root_y
            return root_x != root_y
            
        return all(map(union, edges))
    
# Method2.2: optimal UnionFind, simple compression
class Solution:
def validTree(self, n: int, edges: List[List[int]]) -> bool:
    if len(edges) != n - 1:
        return False

    self.parents = {i:i for i in range(n)}
    self.size = n

    for u, v in edges:
        self.union(u, v)

    return self.size == 1;

def find(self, node):
    path = []
    while node != self.parents[node]:
        path.append(node)
        node = self.parents[node]

    for n in path:
        self.parents[n] = node

    return node

def union(self, u, v):
    root_u, root_v = self.find(u), self.find(v)
    if root_u != root_v:
        self.size -= 1
        self.parents[root_u] = root_v
            
            
    
