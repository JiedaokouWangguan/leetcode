import java.util.PriorityQueue;
import java.util.Comparator;

public class Question23{

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override   
            public int compare(ListNode i1, ListNode i2){
                return i1.val - i2.val;
            }              
        });                

        for(int i = 0;i<lists.length;i++) {
            if(lists[i] == null) continue;;
            pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(pq.size() > 0){ 
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
            if(n.next != null) pq.offer(n.next);
        }                  
        return dummy.next;
    } 


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
