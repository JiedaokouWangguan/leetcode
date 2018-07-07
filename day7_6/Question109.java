import java.util.ArrayDeque;

public class Question109{
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);                
    }

    private TreeNode helper(ListNode node){
        if(node == null)
            return null;
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre != null)
            pre.next = null;
        TreeNode n = new TreeNode(slow.val);
        if(pre == null)
            n.left = null;
        else
            n.left = helper(node);
        n.right = helper(slow.next);
        return n;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
