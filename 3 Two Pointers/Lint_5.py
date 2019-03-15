# https://www.lintcode.com/problem/kth-largest-element/description?_from=ladder&&fromId=1

class Solution:
    """
    @param n: An integer
    @param nums: An array
    @return: the Kth largest element
    """
    def kthLargestElement(self, n, nums):
        if nums is None or len(nums) < n:
            raise ValueError("Invalid Parameters")
            
        return self.partition(len(nums) - n, nums, 0, len(nums) - 1)
        
    def partition(self, n, nums, start, end):
        if start >= end:
            return nums[n]
            
        l, r = start, end
        pivot = nums[(l + r) // 2]
        
        while l <= r:
            while l <= r and nums[l] < pivot:
                l += 1
                
            while l <= r and nums[r] > pivot:
                r -= 1
                
            if l <= r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
                
        if n >= l:
            return self.partition(n, nums, l, end)
        
        if n <= r:
            return self.partition(n, nums, start, r)
            
        return nums[n]
