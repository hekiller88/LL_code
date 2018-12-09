// https://www.lintcode.com/problem/permutations-ii/description

// M1, recursive, temp1 + follow up, 
public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null)
            return ret;
        
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>(), ret);
        
        return ret;
    }
    
    private void helper(int[] nums, 
                        boolean[] visited,
                        List<Integer> permu,
                        List<List<Integer>> ret) {
        if (permu.size() == nums.length) {
            ret.add(new ArrayList<>(permu));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
                
            if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
                
            permu.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, permu, ret);
            visited[i] = false;
            permu.remove(permu.size() - 1);
        }
    }
};

// M2, iterative
