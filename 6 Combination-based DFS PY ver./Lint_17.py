# Easy way
class Solution:
    """
    @param nums: A set of numbers
    @return: A list of lists
    """
    def subsets(self, nums):
        if nums is None:
            return []
            
        ret = []    
        self.dfs(sorted(nums), 0, [], ret)
        
        return ret
        
    def dfs(self, nums, idx, subset, ret):
        if idx == len(nums):
            ret.append(subset[:])
            return
            
        self.dfs(nums, idx + 1, subset + [nums[idx]], ret)
        self.dfs(nums, idx + 1, subset, ret)

#2 General, Backtracking
class Solution:
    """
    @param nums: A set of numbers
    @return: A list of lists
    """
    def subsets(self, nums):
        if nums is None:
            return []
            
        nums.sort()
        ret = []
        self.dfs(nums, 0, [], ret)
        
        return ret
        
    def dfs(self, nums, idx, subset, ret):
        ret.append(subset[:])
        
        for i in range(idx, len(nums)):
            subset.append(nums[i])
            self.dfs(nums, i + 1, subset, ret)
            subset.pop()
        
