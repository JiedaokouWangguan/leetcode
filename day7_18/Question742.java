import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;
public class Question742{
    HashMap<TreeNode, ArrayList<TreeNode>> map = new HashMap<>();
    TreeNode tar = null;
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        dfs(root, k);
        if (tar.left == null && tar.right == null) return k;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(tar);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (map.get(tmp).size() == 0 && tmp != root) return tmp.val;
                for (TreeNode n : map.get(tmp)) {
                    map.get(n).remove(tmp);
                    queue.offer(n);
                }
            }
        }
        return -1;
    }

    private void dfs(TreeNode node, int k) {
        if (!map.containsKey(node)) map.put(node, new ArrayList<TreeNode>());
        if (node.val == k) tar = node;
        if (node.left != null) {
            map.put(node.left, new ArrayList<TreeNode>());
            map.get(node).add(node.left);
            map.get(node.left).add(node);
            dfs(node.left, k);
        }
        if (node.right != null) {
            map.put(node.right, new ArrayList<TreeNode>());
            map.get(node).add(node.right);
            map.get(node.right).add(node);
            dfs(node.right, k);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
