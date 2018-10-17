import java.util.HashMap;

public class Question437{

    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        map.put(0, 1);
        dfs(root, 0, sum);
        return result;
    }

    private void dfs(TreeNode node, int tmpSum, int sum){
        if(node == null) return;
        result += map.getOrDefault(tmpSum+node.val-sum, 0);
        map.put(tmpSum + node.val, 1+map.getOrDefault(tmpSum + node.val, 0));
        dfs(node.left, tmpSum+node.val, sum);
        dfs(node.right, tmpSum+node.val, sum);
        map.put(tmpSum+node.val, map.get(tmpSum+node.val)-1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
