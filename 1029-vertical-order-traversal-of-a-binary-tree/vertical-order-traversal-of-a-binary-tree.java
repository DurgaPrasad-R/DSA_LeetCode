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
class Trio{
    TreeNode node;
    int vertical;
    int row;
    Trio(TreeNode n,int v,int r){
        node = n;
        vertical = v;
        row = r;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Trio> queue = new LinkedList<>();
        queue.add(new Trio(root,0,0));
        while(!queue.isEmpty()){
            Trio temp = queue.poll();
            TreeNode tempNode = temp.node;
            int v = temp.vertical;
            int r = temp.row;
            
            if (!map.containsKey(v)){
                map.put(v,new TreeMap<>());
            }
            if (!map.get(v).containsKey(r)){
                map.get(v).put(r,new PriorityQueue<>());
            }
            map.get(v).get(r).add(tempNode.val);
            if (tempNode.left!=null){
                queue.add(new Trio(tempNode.left,v-1,r+1));
            }
            if (tempNode.right!=null){
                queue.add(new Trio(tempNode.right,v+1,r+1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}