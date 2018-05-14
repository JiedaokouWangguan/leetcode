package leetcode;

/**
 * Created by Song on 2018/5/13.
 */



public class Question814 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode pruneTree(TreeNode root) {
        if (hasOne(root))
            return root;
        else
            return null;
    }

    private boolean hasOne(TreeNode node)
    {
        if (node == null)
            return false;
        boolean left = hasOne(node.left);
        boolean right = hasOne(node.right);
        if (!left)
            node.left = null;
        if(!right)
            node.right = null;
        boolean mid = node.val == 1;
        return left||right||mid;
    }
}
