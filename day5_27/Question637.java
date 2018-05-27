import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Question637{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root)
    {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        if(root == null)
            return result;

        queue.offer(root);
        while(queue.size() != 0)
        {
            int length = queue.size();
            double avg = 0.0;
            for(int i = 0;i<length;i++)
            {
                TreeNode n = queue.poll();
                avg += n.val;
                if(n.left != null)
                    queue.offer(n.left);
                if(n.right != null)
                    queue.offer(n.right);
            }
            avg /= length;
            result.add(avg);
        }
        return result;
    }
}
