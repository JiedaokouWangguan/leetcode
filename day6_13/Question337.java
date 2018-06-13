import java.util.HashMap;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Question337{
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root){
        return helper(root, true);
    }

    private int helper(TreeNode node, boolean tag){
        if(node == null)
            return 0;
        if(tag && map.containsKey(node)){
            return map.get(node);
        }
        int norob = helper(node.left, true) + helper(node.right, true);
        int dorob = helper(node.left, false) + helper(node.right, false) + node.val;
        int more = Math.max(norob, dorob);
        map.put(node, more);
        if(tag){
            return more;
        }
        else{
            return norob;
        }
    }
}
