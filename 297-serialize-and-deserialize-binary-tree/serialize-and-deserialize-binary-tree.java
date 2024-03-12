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
        Queue<TreeNode> q = new LinkedList<>();
        String result = "";
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                TreeNode temp = q.poll();
                if (temp == null){
                    result+="! ";
                    continue;
                }
                result+=temp.val+" ";
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return result.trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodeVals = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int len = nodeVals.length;

        for(int i = 1;i<len;i++){
            TreeNode parent = q.poll();
            if (!nodeVals[i].equals("!")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeVals[i]));
                parent.left = leftNode;
                q.add(leftNode);
            }

            if (!nodeVals[++i].equals("!")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeVals[i]));
                parent.right = rightNode;
                q.add(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));