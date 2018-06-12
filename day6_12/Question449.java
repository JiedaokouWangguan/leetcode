import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}

public class Question449{
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null)
            return "null";
        queue.offer(root);
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            if(node.val == Integer.MIN_VALUE){
                sb.append("null ");
            }
            else{
                sb.append(node.val + " ");
                if(node.left == null){
                    queue.offer(new TreeNode(Integer.MIN_VALUE));
                }
                else{
                    queue.offer(node.left);
                }
                if(node.right == null){
                    queue.offer(new TreeNode(Integer.MIN_VALUE));
                }
                else{
                    queue.offer(node.right);
                }
            }
        }
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }

    public TreeNode deserialize(String data){
        String[] nodes = data.split("\\s+");
        return dfs(nodes, 0);
    }
    private TreeNode dfs(String[] nodes, int index){
        if(index >= nodes.length)
            return null;
        String tmp = nodes[index];
        if(tmp.equals("null")){
            return null;
        }
        else{
            int val = Integer.parseInt(tmp);
            TreeNode n = new TreeNode(val);
            n.left = dfs(nodes, 2*index+1);
            n.right = dfs(nodes, 2*index+2);
            return n;
        }
    }
}
