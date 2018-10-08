public class Question708{
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }              

        Node pre = head;
        Node next = head.next;
        while(next != null){
            if(pre.val <= insertVal && next.val >= insertVal || next.val >= insertVal && next.val <= pre.val || next.val <= pre.val && pre.val <= insertVal){
                Node node = new Node(insertVal, null);
                pre.next = node;
                node.next = next;
                break;
            }          
            pre = next;
            next = next.next;
        }              
        return head;   
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
