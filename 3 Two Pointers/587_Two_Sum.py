# https://www.lintcode.com/problem/two-sum-unique-pairs/description?_from=ladder&&fromId=1

class Solution:
    """
    @param nums: an array of integer
    @param target: An integer
    @return: An integer
    """
    def twoSum6(self, nums, target):
        if nums is None or len(nums) < 2:
            return 0
        
        nums.sort()
        l, r = 0, len(nums) - 1
        ans = 0
        
        while l < r:
            sum = nums[l] + nums[r]
            if sum == target:
                ans += 1
                l += 1
                r -= 1
               
                while l < r and nums[l] == nums[l - 1]:
                    l += 1
                   
                while l < r and nums[r] == nums[r + 1]:
                    r -= 1
            elif sum < target:
                l += 1
            else:
                r -= 1
                
        return ans
                   
                
