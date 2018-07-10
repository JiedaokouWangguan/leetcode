import java.util.HashMap;

public class Question325{
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)) result = Math.max(result, i - map.get(sum-k));
            if(map.containsKey(sum)) continue;
            map.put(sum, i);
        }
        return result;
    }
}
