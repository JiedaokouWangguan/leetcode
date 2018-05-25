import java.util.Deque;
import java.util.ArrayDeque;

public class BSNonRecurInOrder{
    class Node{
        int val;
        Node left;
        Node right;
    }

    void InOrder(Node root)
    {
        if(root == null)
            return;
        Node cur = root;
        Deque<Node> stack = new ArrayDeque<>();
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
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }
}
