import java.util.List;
import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class Question257{
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;
        if(root.left == null && root.right == null)
            result.add(""+root.val);
        if(root.left != null)
            backTrack(result, ""+root.val, root.left);
        if(root.right != null)
            backTrack(result, ""+root.val, root.right);
        return result;
    }

    private void backTrack(List<String> result, String tmpResult, TreeNode node){
        if(node.left == null && node.right == null){
            result.add(tmpResult+"->"+node.val);
        }
        if(node.left != null)
            backTrack(result, tmpResult+"->"+node.val, node.left);
        if(node.right != null)
            backTrack(result, tmpResult+"->"+node.val, node.right);
    }
}
