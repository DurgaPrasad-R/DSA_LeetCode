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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        int n = preorder.length;
        for(int i = 0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = build(preorder,0,n-1,inorder,0,n-1,inMap);
        return root;   
    }
    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if (inStart>inEnd || preStart>preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = map.get(root.val);
        int numsLeft = inIdx-inStart;
        root.left = build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inIdx-1,map);
        root.right = build(preorder,preStart+numsLeft+1,preEnd,inorder,inIdx+1,inEnd,map);
        return root;
    }
}