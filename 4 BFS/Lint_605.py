from collections import deque

class Solution:
    """
    @param org: a permutation of the integers from 1 to n
    @param seqs: a list of sequences
    @return: true if it can be reconstructed only one or false
    """
    def sequenceReconstruction(self, org, seqs):
        graph = self.build_graph(seqs)
        indegrees = self.build_indegrees(graph)
        
        if len(graph) != len(org):
            return False
        
        queue = deque([node for node in indegrees if indegrees[node] == 0])
        topo_order = []
        while queue:
            if len(queue) > 1:
                return False
                
            node = queue.popleft()
            topo_order.append(node)
            
            for neighbor in graph[node]:
                indegrees[neighbor] -= 1
                if indegrees[neighbor] == 0:
                    queue.append(neighbor)
                    
        return topo_order == org
        
    
    def build_graph(self, seqs):
        graph = dict()
        
        for seq in seqs:
            for node in seq:
                graph.setdefault(node, set())
                
        for seq in seqs:
            for i in range(1, len(seq)):
                graph[seq[i - 1]].add(seq[i])
        
        return graph
    
    def build_indegrees(self, graph):
        indegrees = {node:0 for node in graph}
        
        for node in graph:
            for neighbor in graph[node]:
                indegrees[neighbor] += 1
                
        return indegrees
