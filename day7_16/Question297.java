import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return ser(root);
    }
    
    private String ser(TreeNode root){
        if(root == null) return "#";
        String res = root.val + "," + ser(root.left) + "," + ser(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;
        String[] comp = data.split(",");
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<TreeNodeHolder> holder = new ArrayDeque<>();
        for(String s : comp)
            stack.push(s);
        while(stack.size() != 0){
            String cur = stack.pop();
            if(cur.equals("#"))
                holder.push(new TreeNodeHolder(true , null));
            else{
                TreeNode n = new TreeNode(Integer.parseInt(cur));
                TreeNodeHolder l = holder.pop();
                TreeNodeHolder r = holder.pop();
                n.left = l.isNull ? null : l.node;
                n.right = r.isNull ? null : r.node;
                holder.push(new TreeNodeHolder(false, n));
            }
        }
        return holder.pop().node;

    }
}

class TreeNodeHolder{
    boolean isNull;
    TreeNode node;
    public TreeNodeHolder(boolean isNull, TreeNode node){
        this.isNull = isNull;
        this.node = node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
