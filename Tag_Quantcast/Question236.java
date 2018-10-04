public class Question236{
    // 11.20
    //
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        boolean left = helper(node.left, p, q);
        boolean right = helper(node.right, p, q);
        if(node == p || node == q){
            if((left || right) && result == null) result = node;
            return true;
        }
        else{
            if(left && right && result == null) result = node;
            return right || left;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
