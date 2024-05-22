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
    boolean result = true;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        helper(root, null, null);
        return result;
    }

    public void helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            result = false;
            return;
        }
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}