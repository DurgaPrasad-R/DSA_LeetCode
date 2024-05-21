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
    List<Integer> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        // System.out.println(nodes); Set of nodes
        return buildBalance(0,nodes.size()-1);
    }
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        nodes.add(root.val);
        inOrder(root.right);
    }
    public TreeNode buildBalance(int low,int high) {
        if (low > high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildBalance(low,mid-1);
        root.right = buildBalance(mid+1,high);
        return root;
    }
}