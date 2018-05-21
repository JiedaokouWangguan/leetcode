package leetcode.day5_21;

/**
 * Created by Song on 2018/5/21.
 */
public class Question513
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxDepth = 0;
    int leftMost = 0;
    public int findBottomLeftValue(TreeNode root)
    {
        inOrder(root, 1);
        return leftMost;
    }

    private void inOrder(TreeNode node, int depth)
    {
        if (node == null)
            return;
        inOrder(node.left, depth+1);
        if (depth > maxDepth)
        {
            leftMost = node.val;
            maxDepth = depth;
        }
        inOrder(node.right, depth+1);
    }
}
