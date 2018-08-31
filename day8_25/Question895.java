package leetcode.day8_25;

import sun.awt.image.ImageWatched;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class FreqStack {
    HashMap<Integer, Integer> count = new HashMap<>();
    HashMap<Integer, ArrayDeque<Integer>> stacks = new HashMap<>();
    int max = 0;

    public FreqStack() {

    }

    public void push(int x) {
        if(!count.containsKey(x)){
            count.put(x, 1);
            max = Math.max(1, max);
            if(!stacks.containsKey(1)) stacks.put(1, new ArrayDeque<>());
            stacks.get(1).push(x);
        }
        else{
            int tmpCount = count.get(x);
            max = Math.max(max, tmpCount + 1);
            count.put(x, tmpCount + 1);
            if (!stacks.containsKey(tmpCount + 1)) stacks.put(tmpCount + 1, new ArrayDeque<>());
            stacks.get(tmpCount + 1).push(x);
        }
    }

    public int pop() {
        int result = stacks.get(max).pop();
        count.put(result, count.get(result) - 1);
        if (stacks.get(max).size() == 0) max -= 1;
        return result;
    }
}

