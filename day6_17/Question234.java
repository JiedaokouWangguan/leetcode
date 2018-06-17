import java.util.ArrayDeque;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}

public class Question234{
    public boolean isPalindrome(ListNode head){
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode tmpHead = head;
        int length = 0;
        while(tmpHead != null){
            length += 1;
            tmpHead = tmpHead.next;
        }
        boolean isEven = length % 2 ==0;
        length = length/2;
        tmpHead = head;
        for(int i = 0;i<length;i++){
            stack.push(tmpHead);
            tmpHead = tmpHead.next;
        }
        if(!isEven)
            tmpHead = tmpHead.next;
        for(int i = 0;i<length;i++){
            if(stack.pop().val == tmpHead.val){
                tmpHead = tmpHead.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
