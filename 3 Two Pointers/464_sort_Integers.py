# heap sort

class Solution:
    
    """
    @param A: an integer array`
    @return: nothing
    """
    def sortIntegers2(self, A):
        n = len(A)
        
        for i in range(int(n / 2) - 1, -1, -1):
            self.heapify(A, n, i)
            
        for i in range(n - 1, -1, -1):
            A[i], A[0] = A[0], A[i]
            self.heapify(A, i, 0)

    def heapify(self, A, n, i):
        max = i
        left = i * 2 + 1
        right = left + 1
        
        if left < n and A[left] > A[max]:
            max = left
            
        if right < n and A[right] > A[max]:
            max = right
            
        if max != i:
            A[i], A[max] = A[max], A[i]
            
            self.heapify(A, n, max)
    
