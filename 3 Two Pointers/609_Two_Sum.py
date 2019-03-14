# https://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/description?_from=ladder&&fromId=1

class Solution:
    """
    @param nums: an array of integer
    @param target: an integer
    @return: an integer
    """
    def twoSum5(self, nums, target):
        if nums is None or len(nums) < 2:
            return 0
            
        nums.sort()
        
        l, r = 0, len(nums) - 1
        ans = 0
        while l < r:
            sum = nums[l] + nums[r]
            if (sum > target):
                r -= 1
            else:
                ans += r - l
                l += 1
        
        return ans
