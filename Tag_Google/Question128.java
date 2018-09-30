import java.util.HashMap;
import java.util.HashSet;

public class Question128{
    // 8.14 - 8.21
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        HashMap<Integer, int[]> getByHead = new HashMap<>();
        HashMap<Integer, int[]> getByTail = new HashMap<>();
        for(int num : set){
            int[] cur = new int[]{num, num};
            if(getByHead.containsKey(num+1)){
                int[] tmp = getByHead.remove(num+1);
                cur[1] = Math.max(cur[1], tmp[1]);
            }
            if(getByTail.containsKey(num-1)){
                int[] tmp = getByTail.remove(num-1);
                cur[0] = Math.min(cur[0], tmp[0]);
            }
            getByHead.put(cur[0], cur);
            getByTail.put(cur[1], cur);
        }
        int result = 0;
        for(Integer key : getByHead.keySet()){
            int[] cur = getByHead.get(key);
            result = Math.max(result, cur[1] - cur[0] + 1);
        }
        return result;
    }
}
