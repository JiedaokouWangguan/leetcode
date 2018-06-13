import java.util.HashMap;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Question437{
    HashMap<Integer, Integer> preSum = new HashMap<>();
    public int pathSum(TreeNode root, int sum){
        preSum.put(0, 1);
        return helper(root, sum, 0);
    }

    private int helper(TreeNode node, int sum, int curSum){
        if(node == null)
            return 0;

        curSum += node.val;
        int result = preSum.getOrDefault(curSum - sum, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        result += helper(node.left, sum, curSum) + helper(node.right, sum, curSum);
        preSum.put(curSum, preSum.get(curSum)-1);
        return result;
    }
}
