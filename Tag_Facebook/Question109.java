public class Question109{
    ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        ListNode tmp = head;
        int len = 0;
        while(tmp != null){
            len += 1;
            tmp = tmp.next;
        }
        return helper(0, len-1);
    }

    private TreeNode helper(int begin, int end){
        if(begin > end) return null;
        if(begin == end){
            TreeNode res = new TreeNode(cur.val);
            cur = cur.next;
            return res;
        }
        int mid = (end - begin)/2 + begin;
        TreeNode left = helper(begin, mid-1);
        TreeNode res = new TreeNode(cur.val);
        cur = cur.next;
        res.left = left;
        TreeNode right = helper(mid+1, end);
        res.right = right;
        return res;
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
