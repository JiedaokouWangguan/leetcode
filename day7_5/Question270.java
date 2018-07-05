public class Question270{
    Integer result = null;
    double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return result;
    }

    private void helper(TreeNode n, double target){
        if(n == null)
            return;
        if(result == null || Math.abs(n.val - target) < diff){
            result = n.val;
            diff = Math.abs(n.val - target);
        }
        if(target <= n.val)
            helper(n.left, target);
        else
            helper(n.right, target);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
