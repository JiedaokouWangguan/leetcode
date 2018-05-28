class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question606{
    public String tree2str(TreeNode t){
        if(t == null)
            return "";
        return helper(t);
    }

    private String helper(TreeNode node){
        String result = "" + node.val;
        if(node.left == null && node.right == null)
            return result;
        if(node.left == null)
            result += "()";
        else
            result += "(" + helper(node.left) + ")";
        if(node.right != null)
            result += "(" + helper(node.right) + ")";
        return result;
    }
}
