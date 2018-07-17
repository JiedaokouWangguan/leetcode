import java.util.List;
import java.util.ArrayList;

public class Question589{
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        pre(root, result);
        return result;
    }

    private void pre(Node node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        for(Node n : node.children){
            pre(n, list);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
