import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Question545{
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        if(root.left == null && root.right == null) return result;
        
        List<Integer> tmpResult = new ArrayList<Integer>();
        getLeft(root.left, tmpResult);
        getLeaves(root, tmpResult);
        for(Integer i : tmpResult)
            result.add(i);
        tmpResult = new ArrayList<Integer>();
        getRight(root.right, tmpResult);
        for(int i = tmpResult.size()-1;i>=0;i--)
            result.add(tmpResult.get(i));
        return result;
    } 
    private void getRight(TreeNode node, List<Integer> tmpResult){
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        tmpResult.add(node.val);
        if(node.right != null) getRight(node.right, tmpResult);
        else getRight(node.left, tmpResult);
    }

    private void getLeaves(TreeNode node, List<Integer> tmpResult){
        if(node == null) return;
        if(node.left == null && node.right == null) tmpResult.add(node.val);
        getLeaves(node.left, tmpResult);
        getLeaves(node.right, tmpResult);
    }
    private void getLeft(TreeNode node, List<Integer> tmpResult){
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        tmpResult.add(node.val);
        if(node.left != null) getLeft(node.left, tmpResult);
        else getLeft(node.right, tmpResult);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
