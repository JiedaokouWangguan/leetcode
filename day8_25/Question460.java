package leetcode.day8_25;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Question460{
    public static void main(String[] args){
        LFUCache l = new LFUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        l.get(1);
        l.put(3, 3);
        l.get(2);
        l.get(3);
        l.put(4, 4);
        l.get(1);
        l.get(3);
        l.get(4);
    }
}

class LFUCache {
    HashMap<Integer, Integer> values = new HashMap<>();
    HashMap<Integer, Integer> count = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> cache = new HashMap<>();
    int size = 0;
    int capacity = 0;
    int min = 1;
    public LFUCache(int capacity) {
        cache.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!values.containsKey(key)) return -1;
        int tmpCount = count.get(key);
        count.put(key, tmpCount + 1);
        cache.get(tmpCount).remove(key);
        if(tmpCount == min && cache.get(min).size() == 0) min++;
        if (!cache.containsKey(tmpCount + 1)) cache.put(tmpCount + 1, new LinkedHashSet<>());
        cache.get(tmpCount + 1).add(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if(capacity <= 0)  return;
        if(size >= capacity && !values.containsKey(key)){
            int k = cache.get(min).iterator().next();
            cache.get(min).remove(k);
            values.remove(k);
            if(cache.get(min).size() == 0) min++;
            size -= 1;
        }

        if (!values.containsKey(key)){
            values.put(key, value);
            count.put(key, 1);
            cache.get(1).add(key);
            min = 1;
            size += 1;
        }
        else{
            values.put(key, value);
            get(key);
        }
    }
}
