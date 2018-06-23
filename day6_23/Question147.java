public class Question147{
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = null;

            ListNode dhead = dummy;
            while(dhead.next != null && dhead.next.val < tmp.val){
                dhead = dhead.next;
            }
            tmp.next = dhead.next;
            dhead.next = tmp;
        }
        return dummy.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
