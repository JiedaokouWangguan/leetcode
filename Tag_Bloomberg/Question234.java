public class Question234{
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }                    
        ListNode newHead = reverse(slow.next);
        slow.next = null; 
        while(head != null && newHead != null){
            if(head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }                    
        if(head == null && newHead == null) return true;
        if(head.next == null || newHead.next == null) return true;
        return false;        
    }                        

    private ListNode reverse(ListNode head){
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
