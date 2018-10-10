public class Question114{
    TreeNode last = null;
    public void flatten(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode node){
        if(node == null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(last != null) {
            last.left = null;
            last.right = node;
        }
        last = node;
        helper(left);
        helper(right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
