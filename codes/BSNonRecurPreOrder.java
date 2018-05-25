import java.util.Deque;
import java.util.ArrayDeque;

public class BSNonRecurPreOrder{
    class Node{
        int val;
        Node left;
        Node right;
    }

    void PreOrder(Node root)
    {
        if(root == null)
            return;
        Node cur = root;
        Deque<Node> stack = new ArrayDeque<Node>();
        while(stack.size() != 0 || cur != null)
        {
            while(cur != null)
            {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.size() != 0)
            {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }
}
