import java.util.ArrayDeque;

public class Question430{
    public Node flatten(Node head) { 
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node cur = head;         
        while(cur != null){      
            if(cur.child != null){   
                if(cur.next != null)
                    stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;                                                                            
            }                    
            if(cur.next != null) 
                cur = cur.next;  
            else if(stack.size() != 0){
                Node tmp = stack.pop();
                tmp.prev = cur;  
                cur.next = tmp;  
                cur = cur.next;  
            }                    
            else                 
                cur = null;      
        }                        
        return head;             
    }            
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
