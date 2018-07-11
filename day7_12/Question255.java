import java.util.ArrayDeque;

public class Question255{
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (path.size() !=0 && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
}
