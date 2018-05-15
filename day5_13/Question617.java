package leetcode.day5_13;

/**
 * Created by Song on 2018/5/13.
 */
public class Question617
{
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        if (t1 != null && t2 != null)
        {
            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node;
        }
        else if(t1 != null)
            return t1;
        else
            return t2;
    }


}
