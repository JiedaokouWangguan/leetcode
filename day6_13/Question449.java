import java.util.ArrayDeque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Question449{
    public String serialize(TreeNode root){
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String result = sb.toString();
        return result.substring(0, result.length()-1);
    }

    private void preOrder(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        sb.append(root.val + " ");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public TreeNode deserialize(String data){
        if(data.equals(""))
            return null;
        String[] s = data.split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(String e : s){
            queue.offer(Integer.parseInt(e));
        }
        return buildTree(queue);
    }

    private TreeNode buildTree(ArrayDeque<Integer> queue){
        if(queue.size() == 0)
            return null;
        TreeNode node = new TreeNode(queue.poll());
        ArrayDeque<Integer> child = new ArrayDeque<>();
        while(queue.size() != 0 && queue.peek() < node.val){
            child.offer(queue.poll());
        }
        node.left = buildTree(child);
        node.right = buildTree(queue);
        return node;
    }
}
