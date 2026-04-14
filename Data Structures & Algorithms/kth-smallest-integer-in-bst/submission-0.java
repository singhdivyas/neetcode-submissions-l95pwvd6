/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    

    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger(k);
        AtomicInteger result = new AtomicInteger();
        dfs(root, count, result);
        return result.get();
    }

    private void dfs(TreeNode node, AtomicInteger count, AtomicInteger result) {
        if (node == null || count.get() == 0) return;

        dfs(node.left, count, result);

        if (count.decrementAndGet() == 0) {
            result.set(node.val);
            return;
        }

        dfs(node.right, count, result);
    }


}
