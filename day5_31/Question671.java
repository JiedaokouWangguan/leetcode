class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question671{
    public int findSecondMinimumValue(TreeNode root){
        if(root == null) return -1;
        return getMin(root, root.val);
    }

    private int getMin(TreeNode node, int minValue){
        if(node == null)
            return -1;
        if(node.val != minValue) return node.val;
        int left = getMin(node.left, minValue);
        int right = getMin(node.right, minValue);
        if(left == -1) return right;
        if(right == -1) return left;
        return Math.min(left, right);
    }
}
