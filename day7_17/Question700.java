import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Question700{
    public TreeNode searchBST(TreeNode root, int val) {
        return findNode(root, val);    
    }

    private TreeNode findNode(TreeNode node, int val){
        if(node == null) return null;
        if(node.val == val) return node;
        TreeNode left = findNode(node.left, val);
        if(left != null) return left;
        TreeNode right = findNode(node.right, val);
        if(right != null) return right;
        return null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
