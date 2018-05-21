package leetcode.day5_21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Song on 2018/5/21.
 */
public class Question515
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null)
            return result;

        queue.offer(root);
        while (queue.size() != 0)
        {
            int count = queue.size();
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 0;i < count;i++)
            {
                TreeNode n = queue.poll();
                if (n.val > tmpMax)
                    tmpMax = n.val;
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            }
            result.add(tmpMax);
        }
        return result;
    }
}
