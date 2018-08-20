import java.util.List;
import java.util.ArrayList;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        return enNode(root);
    }

    private TreeNode enNode(Node node){
        if(node == null) return null;
        if(node.children == null || node.children.size() == 0) return new TreeNode(node.val);
        TreeNode left = enNode(node.children.get(0));
        TreeNode cur = left;
        for(int i = 1;i<node.children.size();i++){
            TreeNode right = enNode(node.children.get(i));
            cur.right = right;
            cur = cur.right;
        }
        TreeNode n = new TreeNode(node.val);
        n.left = left;
        return n;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        return deNode(root);
    }

    private Node deNode(TreeNode node){
        if(node == null) return null;
        if(node.left == null) return new Node(node.val, new ArrayList<Node>());
        Node n = new Node(node.val, new ArrayList<Node>());
        TreeNode cur = node.left;
        while(cur != null){
            n.children.add(deNode(cur));
            cur = cur.right;
        }
        return n;
    }

}
