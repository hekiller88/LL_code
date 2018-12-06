public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return an integer
     */
    int ans = 0;
    Map<Integer, Integer> map;
    
    public int pathSum(int[] nums) {
        // write your code here
        map = new HashMap<>();
        for (int i: nums) {
            int key = i / 10;
            int val = i % 10;
            
            map.put(key, val);
        }
        
        dfs(nums[0] / 10, 0);
        
        return ans;
    }
    
    private void dfs(int key, int sum) {
        if (!map.containsKey(key)) 
            return;
        
        sum += map.get(key);
        
        int depth = key / 10;
        int pos = key % 10;
        
        int left = (depth + 1) * 10 + (pos * 2 - 1);
        int right = left + 1;
        
        if (!map.containsKey(left) && !map.containsKey(right)) {
            ans += sum;
            return;
        } 
        
        dfs(left, sum);
        dfs(right, sum);
    }
}
