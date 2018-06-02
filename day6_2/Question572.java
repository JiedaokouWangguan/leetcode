class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question572{
    public boolean isSubtree(TreeNode s, TreeNode t){
        return dfs(s, t);
    }

    private boolean dfs(TreeNode node, TreeNode t){
        if(node == null)
            return false;
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;

        if(node.val == t.val){
            b1 = checker(node, t);
        }
        b2 = dfs(node.left, t);
        b3 = dfs(node.right, t);
        return b1 || b2 || b3;
    }

    private boolean checker(TreeNode cur, TreeNode t){
        if(cur == null && t == null)
            return true;
        if(cur == null || t == null)
            return false;
        if(cur.val != t.val)
            return false;
        boolean left = checker(cur.left, t.left);
        boolean right = checker(cur.right, t.right);
        return left && right;
    }
}
