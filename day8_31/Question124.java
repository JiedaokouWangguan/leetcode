public class Question124{
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int cur = node.val;
        if(left > 0) cur += left;
        if(right > 0) cur += right;
        max = Math.max(max, cur);
        int tmp = Math.max(left, right);
        if(tmp <= 0) return node.val > 0? node.val:0;
        else return node.val + tmp > 0? node.val+tmp:0;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
