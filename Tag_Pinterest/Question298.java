public class Question298{
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val, 0);
        return max;
    }

    private void dfs(TreeNode node, int last, int tmpLen){
        if(node == null) return;
        tmpLen = node.val == last+1?tmpLen+1:1;
        max = Math.max(max, tmpLen);
        dfs(node.left, node.val, tmpLen);
        dfs(node.right, node.val, tmpLen);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
