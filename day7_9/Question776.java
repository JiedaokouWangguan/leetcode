public class Question776{
    TreeNode tmp = null;
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] result = new TreeNode[2];
        if(root == null) return result;
        if(root.val == V){
            result[1] = root.right;
            root.right = null;
            result[0] = root;
        }
        else if(root.val < V){
            TreeNode[] tmp = splitBST(root.right, V);
            root.right = tmp[0];
            result[0] = root;
            result[1] = tmp[1];
        }
        else{
            TreeNode[] tmp = splitBST(root.left, V);
            root.left = tmp[1];
            result[0] = tmp[0];
            result[1] = root;
        
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
