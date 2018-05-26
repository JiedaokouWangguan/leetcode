import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Question230{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    ArrayList<Integer> array = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    public int kthSmallest(TreeNode r, int k)
    {
        helper(r);
        return array.get(k-1);
    }

    private void helper(TreeNode r)
    {
        while(r != null || stack.size() != 0)
        {
            while(r != null)
            {
                stack.push(r);
                r = r.left;
            }
            if(stack.size() != 0)
            {
                r = stack.pop();
                array.add(r.val);
                r = r.right;
            }
        }
    }
}
