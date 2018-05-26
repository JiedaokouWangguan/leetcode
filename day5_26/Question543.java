public class Question543{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return maxLength-1;
    }
    private int helper(TreeNode n)
    {
        if(n == null)
            return 0;
        int left = helper(n.left);
        int right = helper(n.right);
        maxLength = Math.max(maxLength, left + right + 1);
        return Math.max(left, right) + 1;
    }

}
