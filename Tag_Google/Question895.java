import java.util.HashMap;
import java.util.ArrayDeque;

public class Question895{}

class FreqStack {
    // 8.34 - 8.42
    HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
    HashMap<Integer, Integer> count = new HashMap<>();
    int max = 0;
    int size = 0;
    public FreqStack() {
        
    }

    public void push(int x) {
        count.put(x, count.getOrDefault(x, 0)+1);
        int curCount = count.get(x);
        if(!map.containsKey(curCount)) map.put(curCount, new ArrayDeque<>());
        map.get(curCount).push(x);
        max = Math.max(max, curCount);
        size += 1;
    }

    public int pop() {
        if(size == 0) return -1;
        int result = map.get(max).pop();
        count.put(result, count.get(result)-1);
        if(map.get(max).size() == 0) max -= 1;
        size -= 1;
        return result;
    }
}
