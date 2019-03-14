# https://www.lintcode.com/problem/two-sum-greater-than-target/description?_from=ladder&&fromId=1

class Solution:
    """
    @param nums: an array of integer
    @param target: An integer
    @return: an integer
    """
    def twoSum2(self, nums, target):
        if nums is None or len(nums) < 2:
            return 0
            
        nums.sort()
        
        l, r = 0, len(nums) - 1
        cnt = 0
        while l < r:
            sum = nums[l] + nums[r]
            if sum <= target:
                l += 1
            else:
                cnt += r - l
                r -= 1
                
        return cnt
