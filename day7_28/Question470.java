import java.util.Stack;


public class Question470{
    Stack<Integer> cache = new Stack<Integer>();
    public int rand10() {
        while (cache.empty()) generate();
        return cache.pop();
    }

    void generate() {
        int n = 19;
        long cur = 0, range = (long)Math.pow(7, n);
        for (int i = 0; i < n; ++i) 
            cur += (long)Math.pow(7, i) * (rand7() - 1);
        while (cur < range / 10 * 10) {
            cache.push((int)(cur % 10 + 1));
            cur /= 10;
            range /= 10;
        }
    }
}
