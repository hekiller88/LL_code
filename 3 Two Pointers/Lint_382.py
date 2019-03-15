# https://www.lintcode.com/problem/triangle-count/description?_from=ladder&&fromId=1

class Solution:
    """
    @param S: A list of integers
    @return: An integer
    """
    def triangleCount(self, S):
        # a + b > c
        if S is None or len(S) < 3:
            return 0
        
        S.sort()
        
        cnt = 0  
        for i in range(2, len(S)):
            l, r = 0, i - 1
            while l < r:
                sum = S[l] + S[r]
                if sum > S[i]:
                    cnt += r - l
                    r -= 1
                else:
                    l += 1
                    
        return cnt
