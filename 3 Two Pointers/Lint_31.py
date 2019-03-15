# https://www.lintcode.com/problem/partition-array/description

public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            while (l <= r && nums[l] < k)
                l++;
            
            while (l <= r && nums[r] >= k)
                r--;
                
            if (l <= r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = nums[l];
                
                l++;
                r--;
            }
        }
        
        return l;
    }
}
