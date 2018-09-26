import java.util.HashMap;

public class Question138{
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while(head != null){
            cur.next = new RandomListNode(head.label);
            cur = cur.next;
            cur.random = head.random;
            map.put(head, cur);
            head = head.next;
        }
        cur = dummy.next;
        while(cur!=null){
            if(cur.random != null)
                cur.random = map.get(cur.random);
            cur = cur.next;
        }
        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
