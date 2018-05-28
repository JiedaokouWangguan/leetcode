class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Question783{
    
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root){
        InOrder(root);
        return minDiff;
    }

    private void InOrder(TreeNode node){
        if(node == null)
            return;

        InOrder(node.left);
        if(pre == null)
            pre = node;
        else{
            minDiff = Math.min(minDiff, Math.abs(pre.val - node.val));
            pre = node;
        }
        InOrder(node.right);
    }
}
