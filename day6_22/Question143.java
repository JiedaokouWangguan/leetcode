public class Question143{
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode tmpHead = head;
        while(tmpHead != null){
            count += 1;
            tmpHead = tmpHead.next;
        }
        int first = count - count/2;
        tmpHead = head;
        for(int i = 0;i<first-1;i++)
            tmpHead = tmpHead.next;
        ListNode caonima = tmpHead.next;
        tmpHead.next = null;
        tmpHead.next = caonima;
        ListNode dummy = new ListNode(0);
        while(tmpHead != null){
            ListNode cur = tmpHead;
            tmpHead = tmpHead.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        dummy = dummy.next;
        tmpHead = head;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(tmpHead != null || dummy != null){
            if(tmpHead != null){
                cur.next = tmpHead;
                tmpHead = tmpHead.next;
                cur = cur.next;
            }
            if(dummy != null){
                cur.next = dummy;
                dummy = dummy.next;
                cur = cur.next;
            }
        }
        cur.next = null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
