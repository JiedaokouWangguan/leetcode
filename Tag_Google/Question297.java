import java.util.ArrayDeque;

// 2.35 - 2.41, 7mins
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();       
        buildString(root, sb);
        String res = sb.toString();
        res = res.substring(0, res.length()-1);
        return res;
    }

    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
        }
        else{
            sb.append(root.val + ",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String str : strs) queue.offer(str);
        return buildTree(queue);
    }

    private TreeNode buildTree(ArrayDeque<String> queue){
        String cur = queue.poll();
        if(cur.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
