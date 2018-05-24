package leetcode.day5_24;

/**
 * Created by Song on 2018/5/24.
 */
public class Question404
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeave(root, false);
        return result;
    }

    private void sumOfLeftLeave(TreeNode node, boolean isLeft)
    {
        if (node == null)
            return;
        if (node.left == null && node.right == null && isLeft)
            result += node.val;
        sumOfLeftLeave(node.left, true);
        sumOfLeftLeave(node.right, false);
    }
}
