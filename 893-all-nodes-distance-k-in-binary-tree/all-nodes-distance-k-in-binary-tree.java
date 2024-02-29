/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp.left!=null){
                parent_track.put(temp.left,temp);
                q.add(temp.left);
            }
            if (temp.right!=null){
                parent_track.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        markParents(root,parent_track);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if (ans == k) break;
            ans++;
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.poll();
                if (temp.left!=null && !visited.contains(temp.left)){
                    visited.add(temp.left);
                    queue.add(temp.left);
                }
                if (temp.right!=null && !visited.contains(temp.right)){
                    visited.add(temp.right);
                    queue.add(temp.right);
                }
                if (parent_track.get(temp)!=null && !visited.contains(parent_track.get(temp))){
                    visited.add(parent_track.get(temp));
                    queue.add(parent_track.get(temp));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
        }
        return result;
    }
}