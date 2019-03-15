# https://www.lintcode.com/problem/sort-colors/description?_from=ladder&&fromId=1

# 1. partition x 2: partition 0 + partition 1
class Solution:
    """
    @param nums: A list of integer which is 0, 1 or 2 
    @return: nothing
    """
    def sortColors(self, nums):
        index = self.partition(nums, 0, 0, len(nums) - 1)
        self.partition(nums, 1, index, len(nums) - 1)
    
    def partition(self, nums, pivot, start, end):
        if start >= end:
            return start
            
        l, r = start, end
        while l <= r:
            while l <= r and nums[l] <= pivot:
                l += 1
            
            while l <= r and nums[r] > pivot:
                r -= 1
                
            if l <= r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
                
        return start
        
# 2. 3 Pointers
class Solution:
    """
    @param nums: A list of integer which is 0, 1 or 2 
    @return: nothing
    """
    def sortColors(self, nums):
        if nums is None or len(nums) < 3:
            return
        
        l, i, r = 0, 0, len(nums) - 1
        while i <= r:
            if nums[i] == 1:
                i += 1
            elif nums[i] == 0:
                nums[i], nums[l] = nums[l], nums[i]
                i += 1
                l += 1
            else:
                nums[i], nums[r] = nums[r], nums[i]
                r -= 1
                
        
        
