import java.util.ArrayDeque;

public class Question369{
    public ListNode plusOne(ListNode head) {
        ListNode n = head;
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        while(n != null){
            stack.push(n);
            n = n.next;
        }
        int carry = 1;
        ListNode dummy = new ListNode(0);
        while(stack.size() > 0){
            ListNode tmp = stack.pop();
            int tmpValue = (tmp.val + carry) % 10;
            carry = (tmp.val + carry) / 10;
            tmp.val = tmpValue;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        if(carry != 0){
            ListNode tmp = new ListNode(carry);
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
