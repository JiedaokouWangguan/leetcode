import java.util.Deque;
import java.util.ArrayDeque;

class StockSpanner {
    Deque<int[]> stack = new ArrayDeque<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int[] cur = new int[]{price, 1};
        while (stack.size() > 0 && stack.peek()[0] <= price){
            int[] tmp = stack.pop();
            cur[1] += tmp[1];
        }
        stack.push(cur);
        return stack.peek()[1];
    }
}
