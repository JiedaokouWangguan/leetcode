import java.util.Deque;
import java.util.ArrayDeque;

class Node{
    int val;
    Node left;
    Node right;
    Node(int x){val = x;}
}
public class BSNonRecurPostOrder{
    
    public static void main(String[] args)
    {
        BSNonRecurPostOrder bs = new BSNonRecurPostOrder();
        Node n1 = new Node(6);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        n1.left = n2;
        n1.right = n3;
        Node n4 = new Node(1);
        n2.right = n4;
        Node n5 = new Node(4);
        Node n6 = new Node(3);
        n3.right = n5;
        n5.left = n6;
        bs.PreOrder(n1);
    }

    void PreOrder(Node root)
    {
        if(root == null)
            return;
        Node cur = root;
        Node lastNode = null;
        Deque<Node> stack = new ArrayDeque<Node>();
        while(stack.size() != 0 || cur != null)
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.size() != 0)
            {
                cur = stack.pop();
                if(cur.right == null || cur.right == lastNode)
                {
                    System.out.println(cur.val);
                    lastNode = cur;
                    cur = null;
                }
                else
                {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
    }
}
