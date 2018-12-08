// https://www.lintcode.com/problem/subsets-ii/my-submissions

// M1, standard template, recursive
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) {
            return ret;
        }
        
        Arrays.sort(nums);
        
        dfs(nums, 0, new ArrayList<>(), ret);
        return ret;
    }
    
    private void dfs(int[] nums,
                     int startIndex,
                     List<Integer> subset,
                     List<List<Integer>> ret) {
        ret.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1])
                continue;
            
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, ret);
            subset.remove(subset.size() - 1);
        }
    }
}

// M2, add the number to the last pos
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null)
            return ret;
            
        Arrays.sort(nums);
        
        ret.add(new ArrayList<>());
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1])
                start = 0;
            
            int size = ret.size();
            for (int j = start; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(ret.get(j));
                newSubset.add(nums[i]);
                ret.add(newSubset);
            }
            
            start = size;
        }
        
        return ret;
    }
}
