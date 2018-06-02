class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

/*
 *public ListNode oddEvenList(ListNode head) {
         if(head == null || head.next == null) return head;
                 ListNode lastOdd = head, lastEven = head.next, firstEven = lastEven;
                         while(lastOdd.next != null && lastEven.next != null){
                                     lastOdd.next = lastEven.next;
                                                 lastOdd = lastOdd.next;
                                                             lastEven.next = lastOdd.next;
                                                                         lastEven = lastEven.next;
                                                                                 }
                                                                                         lastOdd.next = firstEven;
                                                                                                 return head;
                                                                                                     }
 * better solution
 *
 */


public class Question328{
    public ListNode oddEvenList(ListNode head){
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddHead = odd;
        ListNode evenHead = even;
        boolean isOdd = true;
        ListNode curHead = head;
        while(curHead != null){
            if(isOdd){
                isOdd = !isOdd;
                ListNode tmp = new ListNode(curHead.val);
                oddHead.next = tmp;
                curHead = curHead.next;
                oddHead = oddHead.next;
            }
            else{
                isOdd = !isOdd;
                ListNode tmp = new ListNode(curHead.val);
                evenHead.next = tmp;
                curHead = curHead.next;
                evenHead = evenHead.next;
            }
        }
        oddHead.next = even.next;
        return odd.next;
    }
}
