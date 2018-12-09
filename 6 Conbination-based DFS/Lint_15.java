// https://www.lintcode.com/problem/permutations/description

// M1, temp1
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null)
            return ret;
                
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
                
            permu.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, permu, ret);
            visited[i] = false;
            permu.remove(permu.size() - 1);
        }
    }
}

// M2, iterative, insert num to any position
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (nums == null)
            return ret;
             
        ret.add(new ArrayList<>());
        
        for (int num: nums) {
            int size = ret.size();
            for (; size > 0; size--) {
                List<Integer> tmp = new ArrayList<>(ret.pollFirst());
                
                for (int i = 0; i <= tmp.size(); i++) {
                    tmp.add(i,num);
                    ret.add(new ArrayList<>(tmp));
                    tmp.remove(i);
                }
            }
        }
        
        return ret;
    }
    
    
}
