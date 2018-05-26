import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Question199{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public List<Integer> rightSideView(TreeNode root)
    {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
        queue.offer(root);
        while(true)
        {
            int length = queue.size();
            for(int i = 0;i<length;i++)
            {
                TreeNode tmp = queue.poll();
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
                if(i == length - 1)
                    result.add(tmp.val);
            }
            if(queue.size() == 0)
                break;
        }
        return result;
    }
}
/*
 * 也可以直接按照 右子树-》左子树的顺序遍历，这样当看到目标层数的第一个元素时即可进行插入操作
 */
