import java.util.HashMap;
import java.util.HashSet;
public class Question403{
    HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    int dst = 0;
    public boolean canCross(int[] stones) {
        for(int i : stones) set.add(i);
        return dp(stones, stones[0], 0);
    
    }


    private boolean dp(int[] stones, int curIndex, int curK){
        if(map.containsKey(curIndex) && map.get(curIndex).containsKey(curK)) return map.get(curIndex).get(curK);
        if(!map.containsKey(curIndex)) map.put(curIndex, new HashMap<Integer, Boolean>());
        boolean tag = false;
        for(int i = curK-1;i<=curK+1;i++){
            if(i <= 0) continue;
            if(curIndex + i == stones[stones.length-1]) return true;
            if(!set.contains(curIndex+i)) continue;
            tag |= dp(stones, curIndex+i, i);
        }
        map.get(curIndex).put(curK, tag);
        return tag;
    }

}
