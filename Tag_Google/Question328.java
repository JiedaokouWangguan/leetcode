
public class Question328{
    public ListNode oddEvenList(ListNode head) {
        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);
        
        ListNode evenCur = evenDummy;
        ListNode oddCur = oddDummy;
        int count = 1;
        while(head != null){
            if(count % 2 == 1){
                oddCur.next = head;
                oddCur = oddCur.next;
            }
            else{
                evenCur.next = head;
                evenCur = evenCur.next;
            }
            count += 1;
            head = head.next;
        }
        evenCur.next = null;
        oddCur.next = evenDummy.next;
        return oddDummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
