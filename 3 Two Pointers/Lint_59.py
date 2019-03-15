# https://www.lintcode.com/problem/3sum-closest/description?_from=ladder&&fromId=1

class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target: An integer
    @return: return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, nums, target):
        if nums is None or len(nums) < 3:
            raise ValueError("Illegal Argument")
            
        nums.sort()
        
        diff = sys.maxsize
        ans = 0
        for i in range(len(nums)):
            l, r = i + 1, len(nums) - 1    
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                
                if sum == target:
                    return sum
                elif sum < target:
                    if target - sum < diff:
                        diff = target - sum
                        ans = sum
                    l += 1
                else:
                    if sum - target < diff:
                        diff = sum - target
                        ans = sum
                    r -= 1
                    
        return ans
                
