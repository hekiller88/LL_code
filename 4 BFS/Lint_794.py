# https://www.lintcode.com/problem/sliding-puzzle-ii/description?_from=ladder&&fromId=1


# Method 1: my Ans, matrix -> list, tuple
from collections import deque

class Solution:
    """
    @param init_state: the initial state of chessboard
    @param final_state: the final state of chessboard
    @return: return an integer, denote the number of minimum moving
    """
    def minMoveStep(self, init_state, final_state):
        if not init_state or not final_state:
            return -1
            
        if (len(init_state) != 3 or len(final_state) != 3
            or len(init_state[0]) != 3 or len(final_state[0]) != 3):
                return -1
                
        def flatten(mat):
            ret = []
            for i in range(len(mat)):
                for j in range(len(mat[0])):
                    ret.append(mat[i][j])
                    
            return ret
        
        def find_zero(arr):
            for i in range(len(arr)):
                if arr[i] == 0:
                    return i
                        
            return None
            
        def move_zero(idx):
            x, y = idx // 3, idx % 3
            ret = []
            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                new_x, new_y = x + dx, y + dy
                
                if not (0 <= new_x < 3 and 0 <= new_y < 3):
                    continue
                
                new_idx = new_x * 3 + new_y
                ret.append(new_idx)
            
            return ret
                    
        src = flatten(init_state)
        dst = flatten(final_state)
        
        if src == dst:
            return 0
        
        queue = deque([src])
        visited = set([tuple(src)])
        
        steps = 0
        while queue:
            steps += 1
            
            for _ in range(len(queue)):
                curt = queue.popleft()
                idx = find_zero(curt)
                
                for new_idx in move_zero(idx):
                    new_curt = curt[:]
                    new_curt[idx], new_curt[new_idx] = new_curt[new_idx], new_curt[idx]
                    
                    if tuple(new_curt) in visited:
                        continue
                    
                    if new_curt == dst:
                        return steps
                    
                    queue.append(new_curt)
                    visited.add(tuple(new_curt))
                
        return -1

        
