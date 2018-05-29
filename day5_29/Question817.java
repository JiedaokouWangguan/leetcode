import java.util.HashSet;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Question817{
    public int numComponents(ListNode head, int[] G){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int result = 0;
        for(int g : G){
            set.add(g);
        }
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur.val)){
                if(count == 0){
                    count = 1;
                    result += 1;
                }
            }
            else{
                count = 0;
            }
            cur = cur.next;
        }
        return result;
    }
}
