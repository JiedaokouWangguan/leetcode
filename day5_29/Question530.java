class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question530{
    int last = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        if(last == -1)
            last = node.val;
        else{
            min = Math.min(min, Math.abs(last - node.val));
            last = node.val;
        }
        inOrder(node.right);
    }
}
