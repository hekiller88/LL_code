// https://www.lintcode.com/problem/combination-sum/description

// M1, template
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null) 
            return ret;
            
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(int[] nums,
                        int start,
                        int remain,
                        List<Integer> subset,
                        List<List<Integer>> ret) {

        if (remain == 0) {
            ret.add(new ArrayList<>(subset));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if ( i > start && nums[i] == nums[i - 1])
                continue;
                
            if (remain - nums[i] < 0)
                break;
                
            subset.add(nums[i]);
            helper(nums, i, remain - nums[i], subset, ret);
            subset.remove(subset.size() - 1);
        }
    }
}
