class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}

public class Question203{
    public ListNode removeElements(ListNode head, int val){
        ListNode dummy = new ListNode(0);
        ListNode dummyCur = dummy;
        while(head != null){
            if(head.val != val){
                dummyCur.next = head;
                head = head.next;
                dummyCur = dummyCur.next;
            }
            else{
                head = head.next;
            }
        }
        dummyCur.next = null;
        return dummy.next;
    }
}
