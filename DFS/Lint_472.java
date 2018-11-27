// https://www.lintcode.com/problem/binary-tree-path-sum-iii/description

// M1, personal solution, using template
public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if (root != null)
            traverse(root, target, ret);
        
        return ret;
    }
    
    private void traverse(ParentTreeNode root, 
                          int target, 
                          List<List<Integer>> ret) {
        if (root == null)
            return;
        
        dfs(new HashSet<>(), root, target, new ArrayList<>(), ret);
        
        traverse(root.left, target, ret);
        traverse(root.right, target, ret);
    }
    
    private void dfs(Set<ParentTreeNode> hset, 
                     ParentTreeNode root, 
                     int remain, 
                     List<Integer> path,
                     List<List<Integer>> ret) {
        if (root == null || hset.contains(root))
            return;
            
        path.add(root.val);
        hset.add(root);
        remain -= root.val;
        if (remain == 0) {
            ret.add(new ArrayList<>(path));
        }
        
        dfs(hset, root.parent, remain, path, ret);
        dfs(hset, root.left, remain, path, ret);
        dfs(hset, root.right, remain, path, ret);
        
        path.remove(path.size() - 1);
    }
}

// M2, lintcode other solution
public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
            
        traverse(root, target, result);
        
        return result;
    }
    
    private void traverse(ParentTreeNode node, 
                          int target, 
                          List<List<Integer>> result) {
        if (node == null)
            return;
        
        dfs(node, null, target, new LinkedList<Integer>(), result);
        
        traverse(node.left, target, result);
        traverse(node.right, target, result);
    }
    
    private void dfs(ParentTreeNode node,
                     ParentTreeNode back,
                     int remain,
                     List<Integer> path,
                     List<List<Integer>> result)  {
        if (node == null)
            return;
            
        path.add(node.val);
        remain -= node.val;
        
        if (remain == 0) {
            result.add(new ArrayList<>(path));
        }
        
        if (node.parent != null && node.parent != back) {
            dfs(node.parent, node, remain, path, result);
        }
        
        if (node.left != null && node.left != back) {
            dfs(node.left, node, remain, path, result);
        }
        
        if (node.right != null && node.right != back) {
            dfs(node.right, node, remain, path, result);
        }
        
        path.remove(path.size() - 1);
    }
}
