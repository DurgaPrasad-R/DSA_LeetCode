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
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode n,int l){
        node = n;
        level = l;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair tempPair = q.poll();
            TreeNode tempNode = tempPair.node;
            int l = tempPair.level;
            map.put(l,tempNode.val);
            if (tempNode.left!=null) q.add(new Pair(tempNode.left,l+1));
            if (tempNode.right!=null) q.add(new Pair(tempNode.right,l+1));
        }
        for(int node:map.values()){
            list.add(node);
        }
        return list;
    }
}