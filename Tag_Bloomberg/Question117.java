public class Question117{
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode cur = dummy;
        while(root != null){
            if(root.left != null){
                if(dummy.next == null) dummy.next = root.left;
                cur.next = root.left;
                cur = cur.next;
            }   
            if(root.right != null){
                if(dummy.next == null) dummy.next = root.right;
                cur.next = root.right;
                cur = cur.next;
            }   
            root = root.next;
            if(root == null && dummy.next != null){
                root = dummy.next;
                dummy.next = null;
                cur = dummy;
            }   
        }                                                                                          
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
