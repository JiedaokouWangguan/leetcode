import java.util.Random;

public class Question382{
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    
    int nextRandom = 0;
    ListNode h = null;
    public Question382(ListNode head){
        h = head;
    }

    public int getRandom(){
        Random random = new Random();
        nextRandom = h.val;
        h = h.next;
        int count = 1;
        while(h != null)
        {
            int ran = random.nextInt(1 + count);
            if(ran == count)
            {
                nextRandom = h.val;
            }
            count++;
            h = h.next;
        }
        return nextRandom;
    }
}
