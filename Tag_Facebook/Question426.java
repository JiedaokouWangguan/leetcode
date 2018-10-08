public class Question426{
    Node dummy = new Node();
    Node cur = dummy;
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        cur.right = dummy.right;
        dummy.right.left = cur;
        return dummy.right;
    }

    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        node.left = cur;
        cur.right = node;
        cur = cur.right;
        inOrder(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
