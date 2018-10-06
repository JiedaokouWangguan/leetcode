public class Question222{
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if(h == 0) return 0;
        int rightHeight = getHeight(root.right);
        if(h == rightHeight + 1){
            return 1 + (int)Math.pow(2, h-1) - 1 + countNodes(root.right);
        }
        else{
            return 1 + (int)Math.pow(2, rightHeight) - 1 + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode node){
        if(node == null) return 0;
        else return 1 + getHeight(node.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
