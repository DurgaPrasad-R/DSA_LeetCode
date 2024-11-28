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
class Triple {
    int v,r;
    TreeNode node;
    Triple(int v,int r,TreeNode node) {
        this.v = v;
        this.r = r;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (res == null) return res;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(0,0,root));
        while(!q.isEmpty()) {
            Triple t = q.poll();
            int v = t.v;
            int r = t.r;
            TreeNode n = t.node;
            if (!map.containsKey(v)) {
                map.put(v,new TreeMap<>());
            }
            if (!map.get(v).containsKey(r)) {
                map.get(v).put(r,new PriorityQueue<>());
            }
            map.get(v).get(r).add(n.val);
            if (n.left != null) {
                q.add(new Triple(v-1,r+1,n.left));
            }
            if (n.right != null) {
                q.add(new Triple(v+1,r+1,n.right));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> ele :  map.values()) {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> vals : ele.values()) {
                while (!vals.isEmpty()) {   
                    res.get(res.size()-1).add(vals.poll());
                }
            }
        }
        return res;
    }
}