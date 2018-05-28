class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}
}

public class Question237{
    public void deleteNode(ListNode node){
        ListNode next = node.next;
        while(next.next != null){
            node.val = next.val;
            node = node.next;
            next = next.next;
        }
        node.val = next.val;
        node.next = null;
    }
}
