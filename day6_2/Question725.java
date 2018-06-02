class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Question725{
    public ListNode[] splitListToParts(ListNode root, int k){
        int count = 0;
        ListNode tmpHead = root;
        while(tmpHead != null){
            count += 1;
            tmpHead = tmpHead.next;
        }

        int partLength = count / k;
        int mod = count % k;
        
        ListNode[] result = new ListNode[k];
        ListNode curNode = root;
        for(int i = 0;i<k;i++){
            int n = partLength;
            if(mod > 0)
                n += 1;
            mod -= 1;

            result[i] = curNode;
            for(int j = 0;j<partLength-1;j++){
                curNode = curNode.next;
            }
            if(curNode != null){
                ListNode tmp = curNode;
                curNode = curNode.next;
                tmp.next = null;
            }
        }
        return result;
    }
}
