import java.util.HashMap;
import java.util.HashSet;
public class Question403{
    HashSet<Integer> sto = new HashSet<>();
    HashMap<String, Boolean> map = new HashMap<>();
    // 6.57 - 7.07, 11mins
    public boolean canCross(int[] stones) {
        for(int i : stones) sto.add(i);
        return helper(stones[stones.length-1], 0, 0);
    }

    private boolean helper(int target, int position, int k){
        if(target == position) return true;
        String key = position + "," + k;
        if(map.containsKey(key)) return map.get(key);
        boolean result = false;
        if(k - 1> 0){
            if(sto.contains(position + k - 1))
                result = result || helper(target, position + k - 1, k - 1);
        }
        if(!result && k > 0){
            if(sto.contains(position + k))
                result = result || helper(target, position + k, k);
        }
        if(!result){
            if(sto.contains(position + k + 1))
                result = result || helper(target, position + k + 1, k + 1);
        }
        map.put(key, result);
        return result;
    }
}
