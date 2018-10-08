public class Question270{
    
    Integer result = null;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return result;
    }

    private void dfs(TreeNode node, double target){
        if(node == null) return;
        if(result == null) result = node.val;
        else{
            if(Math.abs(result - target) > Math.abs(node.val - target))
                result = node.val;
        }

        if(node.val > target) dfs(node.left, target);
        else dfs(node.right, target);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
