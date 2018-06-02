import java.util.ArrayDeque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}

public class Question623{
    public TreeNode addOneRow(TreeNode root, int v, int d){
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        d -= 1;
        while(d != 1){
            int n = queue.size();
            for(int i = 0;i < n;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
            }
            d -= 1;
        }
        int n = queue.size();
        for(int i = 0;i<n;i++){
            TreeNode tmp = queue.poll();
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = tmp.left;
            right.right = tmp.right;
            tmp.left = left;
            tmo.right = right;
        }
        return root;
    }
}
