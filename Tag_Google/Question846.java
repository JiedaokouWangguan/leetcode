import java.util.HashMap;
import java.util.TreeMap;

public class Question846{
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0) + 1); 
        }   
        int numGroup = 0;

        for(Integer key : map.keySet()){
            if(map.get(key) == 0) continue;
            int count = map.get(key);
            for(int i = 0;i<W;i++){
                int curKey = key + i;
                if(map.getOrDefault(curKey, 0) < count) return false;
                map.put(curKey, map.get(curKey) - count);
            }   
        }   
        return true;
    }  
}
