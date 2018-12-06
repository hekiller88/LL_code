// https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/description

// M1, my ans, brutal
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code heree
         Map<Double, List<TreeNode>> map = createMap(root, target);
         List<Integer> res = new ArrayList<>();
         
         for (List<TreeNode> list: map.values()) {
             for (TreeNode node: list) {
                 res.add(node.val);
             }
             
             k -= list.size();
             if (k == 0) 
                 break;
         }
         
         return res;
    }
    
    private Map<Double, List<TreeNode>> createMap(TreeNode root, double target) {
        Map<Double, List<TreeNode>> tmap = new TreeMap<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            
            double dist = Math.abs(target - curt.val);
            if (!tmap.containsKey(dist)) {
                tmap.put(dist, new ArrayList<>());
            }
            tmap.get(dist).add(curt);
            
            curt = curt.right;
        }
        
        return tmap;
    }
}

// M2, leetcode over simple ver, not optimal complexity
// using inorder + reverse inorder
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List < Integer > closestKValues(TreeNode root, double target, int k) {
        List < Integer > res = new ArrayList < > ();

        Stack < Integer > s1 = new Stack < > (); // predecessors
        Stack < Integer > s2 = new Stack < > (); // successors

        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        System.out.println(s1.toString());
        System.out.println(s2.toString());

        while (k-- > 0) {
            if (s1.isEmpty())
                res.add(s2.pop());
            else if (s2.isEmpty())
                res.add(s1.pop());
            else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
                res.add(s1.pop());
            else
                res.add(s2.pop());
        }

        return res;
    }

    // inorder traversal
    void inorder(TreeNode root, double target, boolean reverse, Stack < Integer > stack) {
        if (root == null) return;

        inorder(reverse ? root.right : root.left, target, reverse, stack);
        // early terminate, no need to traverse the whole tree
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        // track the value of current node
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }
}

// M1 - 2, pred + succ, O(h)
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        
        TreeNode pred = pred(root, target);
        TreeNode succ = succ(root, target);
        for (int i = 0; i < k; i++) {
            if (pred == null) {
                ret.add(succ.val);
                succ = succ(root, succ.val);
            } else if (succ == null) {
                ret.add(pred.val);
                pred = pred(root, pred.val);
            } else {
                if (Math.abs(pred.val - target) < Math.abs(succ.val - target)) {
                    ret.add(pred.val);
                    pred = pred(root, pred.val);
                } else {
                    ret.add(succ.val);
                    succ = succ(root, succ.val);
                }
            }
        }
        
        return ret;
    }
    
    private TreeNode pred(TreeNode root, double target) {
        TreeNode pred = null;
        while (root != null) {
            if (root.val < target) {
                pred = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pred;
    }
    
    private TreeNode succ(TreeNode root, double target) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > target) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}

// M2, optimal, maintain 2 stack
// Stack predecessor: top is the largest node smaller than target
// Stack successor  : top is the smallest node larger than target
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        Stack<TreeNode> pred = new Stack<>(); // top is largest ele smaller than target
        Stack<TreeNode> succ = new Stack<>(); // top is smallest ele larger than target
        
        //initialize
        TreeNode curt = root;
        while (curt != null) {
            if (target <= curt.val) {
                succ.push(curt);
                curt = curt.left;
            } else {
                pred.push(curt);
                curt = curt.right;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            double dist_p = pred.empty() ? Double.MAX_VALUE : Math.abs(pred.peek().val - target);
            double dist_s = succ.empty() ? Double.MAX_VALUE : Math.abs(succ.peek().val - target);
            
            if (dist_p < dist_s) {
                res.add(pred.peek().val);
                nextPred(pred);
            } else {
                res.add(succ.peek().val);
                nextSucc(succ);
            }
        }
        
        return res;
    }
    
    private void nextPred(Stack<TreeNode> pred) {
        TreeNode node = pred.pop().left;
        
        while (node != null) {
            pred.push(node);
            node = node.right;
        }
    }
    
    private void nextSucc(Stack<TreeNode> succ) {
        TreeNode node = succ.pop().right;
        
        while (node != null) {
            succ.push(node);
            node = node.left;
        }
    }
}
