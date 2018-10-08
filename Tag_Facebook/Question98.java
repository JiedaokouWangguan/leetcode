public class Question98{
    Integer last = null;
    boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);    
        return valid;
    }

    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        if(last == null) last = node.val;
        else{
            if(node.val <= last) valid = false;
            last = node.val;
        }
        inOrder(node.right);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
