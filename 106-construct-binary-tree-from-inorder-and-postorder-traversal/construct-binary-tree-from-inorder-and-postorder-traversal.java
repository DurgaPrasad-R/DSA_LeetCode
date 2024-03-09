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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        int n = inorder.length;
        for(int i = 0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = buildUtil(inorder,0,n-1,postorder,0,n-1,inMap);
        return root;
    }
    public TreeNode buildUtil(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd, Map<Integer,Integer> inMap){
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIdx = inMap.get(root.val);
        int numsLeft = inIdx - inStart;
        root.left = buildUtil(inorder,inStart,inIdx-1,postorder,postStart,postStart+numsLeft-1,inMap);
        root.right = buildUtil(inorder,inIdx+1,inEnd,postorder,postStart+numsLeft,postEnd-1,inMap);
        return root;
    }
}