/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String res = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res+="# ";
                continue;
            }
            res+=curr.val+" ";
            q.offer(curr.left);
            q.offer(curr.right);
        }
        // System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodeVals = data.split(" ");
        int nodeLen = nodeVals.length;
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1;i<nodeLen;i++) {
            TreeNode parent = q.poll();
            if (!nodeVals[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodeVals[i]));
                parent.left = left;
                q.add(left);
            }
            if (!nodeVals[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodeVals[i]));;
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;