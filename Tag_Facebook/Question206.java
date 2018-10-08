public class Question206{
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null){
            ListNode tmp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
