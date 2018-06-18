import java.util.ArrayDeque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class Node{
    TreeNode node;
    int index;
    Node(TreeNode n, int in){
        node = n;
        index = in;
    }
}

public class Question662{
    public int widthOfBinaryTree(TreeNode root){
        if(root == null)
            return 0;
        Node n = new Node(root, 0);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int max = 0;
        queue.offer(n);
        while(queue.size() != 0){
            int len = queue.size();
            int begin = -1;
            int end = -1;
            for(int i = 0;i<len;i++){
                Node tmpNode = queue.poll();
                if(begin == -1)
                    begin = tmpNode.index;
                end = tmpNode.index;
                if(tmpNode.node.left != null)
                    queue.offer(new Node(tmpNode.node.left, 2 * tmpNode.index + 1));
                if(tmpNode.node.right != null)
                    queue.offer(new Node(tmpNode.node.right, 2 * tmpNode.index + 2));
            }
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
}
