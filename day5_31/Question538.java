class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question538{
    public TreeNode convertBST(TreeNode root){
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int preSum){
        if(root == null){
            return preSum;
        }

        int result = helper(root.right, preSum);
        root.val += result;
        result = helper(root.left, root.val);
        return result;
    }
}
