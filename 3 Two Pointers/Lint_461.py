# https://www.lintcode.com/problem/kth-smallest-numbers-in-unsorted-array/description?_from=ladder&&fromId=1

class Solution:
    """
    @param k: An integer
    @param nums: An integer array
    @return: kth smallest element
    """
    def kthSmallest(self, k, nums):
        if nums is None or len(nums) < k:
            return -1
            
        return self.partition(k - 1, nums, 0, len(nums) - 1)
    
    def partition(self, k, nums, start, end):
        if start >= end:
            return nums[k]
            
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
                
        if k >= l:
            return self.partition(k, nums, l, end)
            
        if k <= r:
            return self.partition(k, nums, start, r)
            
        return nums[k]
