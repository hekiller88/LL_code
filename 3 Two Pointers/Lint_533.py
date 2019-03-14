# https://www.lintcode.com/problem/two-sum-closest-to-target/description?_from=ladder&&fromId=1

public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) 
            throw new IllegalArgumentException();
        
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int v = nums[l] + nums[r];
            
            if (v < target) {
                diff = Math.min(diff, target - v);
                l++;
            } else {
                diff = Math.min(diff, v - target);
                r--;
            }
        }
        
        return diff;
        
    }
}
