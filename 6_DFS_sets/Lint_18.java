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

// M2, Vague
public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList()); // add []
        for (int i = 0, prev = 0; i < nums.length; i++) {
            int size = ans.size();
                for (int j = (i == 0 || nums[i] != nums[i - 1]) ? 0 : prev; j < size; j++) {
                    List<Integer> cur = new ArrayList(ans.get(j));
                    cur.add(nums[i]);
                    ans.add(cur);
                }
            prev = size;
        }
        return ans;
}
