import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Question428{
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return null;
        List<String> list = new LinkedList<>();
        ser(root, list);
        return String.join(",", list);
    }

    private void ser(Node node, List<String> list){
        int n = node.children.size();
        list.add(""+node.val);
        list.add(""+n);
        for(int i = 0;i<n;i++){
            ser(node.children.get(i), list);
        }
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null) return null;
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(strs));
        return desNode(queue);    
    }

    private Node desNode(Queue<String> queue){
        int val = Integer.parseInt(queue.poll());
        int len = Integer.parseInt(queue.poll());
        Node n = new Node(val, new ArrayList<Node>());
        for(int i = 0;i<len;i++){
            n.children.add(desNode(queue));
        }
        return n;
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
};
