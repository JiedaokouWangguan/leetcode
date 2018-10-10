import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    HashMap<Integer, Integer> id2count = new HashMap<>();
    HashMap<Integer, Integer> id2value = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> count2id = new HashMap<>();
    int size = 0;
    int cap = 0;
    int min = 1;
    public LFUCache(int capacity) {
        cap = capacity;
        count2id.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        if(!id2value.containsKey(key)) return -1;
        int res = id2value.get(key);
        int oldCount = id2count.get(key);
        id2count.put(key, oldCount+1);
        count2id.get(oldCount).remove(key);
        if(!count2id.containsKey(oldCount+1)) count2id.put(oldCount+1, new LinkedHashSet<>());
        count2id.get(oldCount+1).add(key);
        if(count2id.get(min).size() == 0) min += 1;
        return res;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        if(id2value.containsKey(key)){
            id2value.put(key, value);
            get(key);
        }
        else{
            if(size == cap){
                size -= 1;
                int v = count2id.get(min).iterator().next();
                count2id.get(min).remove(v);
                id2count.remove(v);
                id2value.remove(v);
            }
            size += 1;
            min = 1;
            count2id.get(min).add(key);
            id2count.put(key, 1);
            id2value.put(key, value);
        }
    }
}
