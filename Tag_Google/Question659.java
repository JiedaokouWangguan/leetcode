import java.util.HashMap;
import java.util.HashSet;

public class Question659{
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i : nums) count.put(i, count.getOrDefault(i, 0)+1);
        HashSet<Integer> visited = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        Integer last = null;
        for(int num : nums){
            if(visited.contains(num)) continue;
            visited.add(num);
            int curCount = count.get(num);
            if(last == null || last + 1 != num){
                if(p1 != 0 || p2 != 0) return false;
                p1 = curCount;
            }
            else{
                if(curCount < p1 + p2) return false;
                int tmp1 = Math.max(0, curCount - p1 - p2 - p3);
                int tmp2 = p1;
                int tmp3 = p2 + Math.min(p3, curCount - p1 - p2);
                p1 = tmp1;
                p2 = tmp2;
                p3 = tmp3;
            }
            last = num;
        }
        return p1 == 0 && p2 == 0;
    }
}
