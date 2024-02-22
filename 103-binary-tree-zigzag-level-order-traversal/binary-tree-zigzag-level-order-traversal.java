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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int ans = 0;
        while(!nodes.isEmpty()){
            int n = nodes.size();
            ans+=1;
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode toRemove = nodes.poll();
                temp.add(toRemove.val);
                if (toRemove.left!=null){
                    nodes.add(toRemove.left);
                }
                if (toRemove.right!=null){
                    nodes.add(toRemove.right);
                }
            }
            if (ans%2 == 0) {
                Collections.reverse(temp);
                result.add(temp);
            } else {
                result.add(temp);
            }
        }
        return result;
    }
}