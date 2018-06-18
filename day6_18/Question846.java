import java.util.TreeMap;

public class Question846{
    public boolean isNStraightHand(int[] hand, int w){
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        int count = w;
        for(int key : map.keySet()){
            if(map.get(key) > 0){
                for(int i = w - 1;i>=0;i--){
                    if(map.getOrDefault(key+i, 0) < map.get(key))
                        return false;
                    map.put(key + i, map.get(key+i) - map.get(key));
                }
                count -= map.get(key);
            }
        }
        return true;
    }
}
