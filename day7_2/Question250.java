public class Question250{
    int result = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        sub(root);
        return result;
    }

    private Integer sub(TreeNode n){
        if(n == null)
            return null;
        Integer l = sub(n.left);
        Integer r = sub(n.right);
        if(l == null || r == null){
            if(n.left != null && l == null || n.right != null && r == null)
                return null;
            boolean res = true;
            if(n.left != null)
                res &= n.val == l;
            if(n.right != null)
                res &= n.val == r;
            if(res){
                result += 1;
                return n.val;
            }
            else
                return null;
        }
        else{
            if(n.val == l && n.val == r){
                result += 1;
                return n.val;
            }
            else
                return null;
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}
