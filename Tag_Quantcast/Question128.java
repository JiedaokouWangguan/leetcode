import java.util.HashMap;
import java.util.HashSet;

public class Question128{
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, int[]> getByHead = new HashMap<>();
        HashMap<Integer, int[]> getByTail = new HashMap<>();
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        for(int i : set){
            int[] cur = new int[]{i, i};
            if(getByHead.containsKey(i+1)){
                int[] tmp = getByHead.remove(i+1);
                cur[1] = Math.max(cur[1], tmp[1]);
            }

            if(getByTail.containsKey(i-1)){
                int[] tmp = getByTail.remove(i-1);
                cur[0] = Math.min(cur[0], tmp[0]);
            }

            getByHead.put(cur[0], cur);
            getByTail.put(cur[1], cur);
        }
        
        int max = 0;
        for(Integer key : getByHead.keySet()){
            int[] cur = getByHead.get(key);
            max = Math.max(max, cur[1] - cur[0] + 1);
        }
        return max;
    }
}
