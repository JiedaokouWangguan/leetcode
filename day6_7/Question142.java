class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class Question142{
    
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = fast;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null)
            return null;

        ListNode newHead = head;
        while(newHead != slow){
            newHead = newHead.next;
            slow = slow.next;
        }
        return slow;
    }
}
