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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0;i<n;i++) {
                TreeNode curr = q.poll();
                map.put(level,curr.val);
                if (curr.left!=null) {
                    q.add(curr.left);
                }
                if (curr.right!=null) {
                    q.add(curr.right);
                }
            }
            level+=1;
        }
        for(int val:map.values()) {
            res.add(val);
        }
        return res;
    }
}