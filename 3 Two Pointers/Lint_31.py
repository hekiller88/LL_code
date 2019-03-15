# https://www.lintcode.com/problem/partition-array/description

class Solution:
    """
    @param nums: The integer array you should partition
    @param k: An integer
    @return: The index after partition
    """
    def partitionArray(self, nums, k):
        if nums is None or len(nums) == 0:
            return 0
            
        l, r = 0, len(nums) - 1
        
        while l <= r:
            while l <= r and nums[l] < k:
                l += 1
                
            while l <= r and nums[r] >= k:
                r -= 1
                
            if l <= r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
                
        return min(len(nums) - 1, l)
