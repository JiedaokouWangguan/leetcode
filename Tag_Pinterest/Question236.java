public class Question236{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;
        if(node == p || node == q) return node;
        else{
            TreeNode left = helper(node.left, p, q);
            TreeNode right = helper(node.right, p, q);
            if(left == p && right == q || left == q && right == p) return node;
            else return left == null?right:left;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
