
public class Question865{
    
    int maxLevel = 0;
    int count = 0;
    TreeNode result = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        countMax(root, 0);
        numMaxLevel(root, 0);
        return result;
    }
    
    private int numMaxLevel(TreeNode n, int level){
        if(n == null) return 0;
        if(level == maxLevel){
            if(count == 1) result = n;
            return 1;
        }
        else{
            int left = numMaxLevel(n.left, level+1);
            int right = numMaxLevel(n.right, level+1);
            if(left + right == count && result == null)
                result = n;
            return left + right;
        }
    }

    private void countMax(TreeNode n, int level){
        if(n == null) return;
        if(level > maxLevel){
            maxLevel = level;
            count = 1;
        }
        else if(level == maxLevel)
            count += 1;
        countMax(n.left, level+1);
        countMax(n.right, level+1);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
