package leetcode.day5_23;

/**
 * Created by Song on 2018/5/23.
 */
public class Question729
{
    class Node{
        Node left;
        Node right;
        int leftValue;
        int rightValue;
    }
    class MyCalendar {
        boolean valid = false;
        Node root = null;
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            root = book(start, end, root);
            return valid;
        }

        private Node book(int start, int end, Node node)
        {
            if (node == null)
            {
                Node n = new Node();
                n.left = null;
                n.right = null;
                n.leftValue = start;
                n.rightValue = end;
                valid = true;
                return n;
            }
            else
            {
                if (end <= node.leftValue)
                {
                    node.left = book(start, end, node.left);
                    return node;
                }
                else if (start >= node.rightValue)
                {
                    node.right = book(start, end, node.right);
                    return node;
                }
                else
                {
                    valid = false;
                    return node;
                }
            }
        }
    }
}
