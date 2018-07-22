import java.util.List;
import java.util.ArrayList;

public class Question872{
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = getSequence(root1);
        List<Integer> s2 = getSequence(root2);
        if(s1.size() != s2.size()) return false;
        for(int i = 0;i<s1.size();i++)
            if(s1.get(i) != s2.get(i))
                return false;
        return true;
    }

    private List<Integer> getSequence(TreeNode root){
        List<Integer> seq = new ArrayList<Integer>();
        dfs(root, seq);
        return seq;
    }

    private void dfs(TreeNode node, List<Integer> seq){
        if(node == null) return;
        if(node.left == null && node.right == null) seq.add(node.val);
        else{
            dfs(node.left, seq);
            dfs(node.right, seq);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
