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
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        map.put(0,new ArrayList<>(Arrays.asList(root.val)));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                if (!map.containsKey(level)) map.put(level,new ArrayList<>());
                if (temp.left!=null){
                    map.get(level).add(temp.left.val);
                    q.add(temp.left);
                } 
                if (temp.right!=null){
                    map.get(level).add(temp.right.val);
                    q.add(temp.right);
                }
            }
        }
        return map.get(level-1).get(0);
    }
}