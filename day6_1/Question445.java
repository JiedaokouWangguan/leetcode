import java.util.ArrayDeque;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;} 
}

public class Question445{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while(stack1.size() != 0 && stack2.size() != 0){
            int tmp = carry + stack1.pop() + stack2.pop();
            carry = tmp / 10;
            tmp = tmp % 10;
            ListNode node = new ListNode(tmp);
            node.next = dummy.next;
            dummy.next = node;
        }

        while(stack2.size() != 0){
            int tmp = carry + stack2.pop();
            carry = tmp / 10;
            tmp = tmp % 10;
            ListNode node = new ListNode(tmp);
            node.next = dummy.next;
            dummy.next = node;
        }
        while(stack1.size() != 0){
            int tmp = carry + stack1.pop();
            carry = tmp / 10;
            tmp = tmp % 10;
            ListNode node = new ListNode(tmp);
            node.next = dummy.next;
            dummy.next = node;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
