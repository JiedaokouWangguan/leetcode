import java.util.ArrayDeque;

public class Question662{
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        NodeHolder node = new NodeHolder(root, 0);
        ArrayDeque<NodeHolder> queue = new ArrayDeque<>();
        queue.offer(node);
        int result = 0;
        while(queue.size() > 0){
            int len = queue.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<len;i++){
                NodeHolder nh = queue.poll();
                min = Math.min(min, nh.col);
                max = Math.max(max, nh.col);
                if(nh.node.left != null) queue.offer(new NodeHolder(nh.node.left, nh.col * 2+1));
                if(nh.node.right != null) queue.offer(new NodeHolder(nh.node.right, nh.col * 2+2));
            }
            result = Math.max(result, max - min + 1);
        }
        return result;
    }

}

class NodeHolder{
    TreeNode node;
    int col;
    public NodeHolder(TreeNode _node, int _col){
        node = _node;
        col = _col;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
