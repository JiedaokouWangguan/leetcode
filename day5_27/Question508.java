import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question508{
    Map<Integer, Integer> sumToCount;
    int maxCount;
    
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public int[] findFrequentTreeSum(TreeNode root)
    {
        if(root == null)
            return new int[0];
        maxCount = 0;
        sumToCount = new HashMap<>();
        postOrder(root);
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : sumToCount.keySet())
        {
            if(sumToCount.get(key) == maxCount)
                list.add(key);
        }
        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode node)
    {
        int ret = 0;
        if(node.left != null)
            ret += postOrder(node.left);
        if(node.right != null)
            ret += postOrder(node.right);
        ret += node.val;
        int count = sumToCount.getOrDefault(ret, 0) + 1;
        sumToCount.put(ret, count);
        if(count > maxCount)
            maxCount = count;
        return ret;
    }
}
