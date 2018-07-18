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

class Question426 {
    Node last = null;
    Node first = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null){
            root.left = root;
            root.right = root;
            return root;
        }
        inOrder(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        if(last == null){
            first = node;
            last = node;
        }
        else{
            node.left = last;
            last.right = node;
            last = node;
        }
        inOrder(node.right);
    }
}
